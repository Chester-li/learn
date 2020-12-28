package threadlocal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaoshuai.li
 * @date 2020/12/28
 * @description
 */
public class InheritableThreadLocalTest {

    //线程池
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
            1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
            r -> new Thread(r, "InheritableThreadLocalTest-" + Thread.currentThread().getName()));

    //继承父线程的ThreadLocal数据
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //在新线程内设置ThreadLocal值
        setValue();
        //等待上面赋值动作完成
        Thread.sleep(1000);
        //修改主线程的ThreadLocal值
        threadLocal.set("world");
        //主线程内设置线程中的数据
        increment();
        Thread.sleep(100000);
        System.out.println("over");
    }

    public static void setValue() {
        new Thread(() -> {
            threadLocal.set("hello");
            increment();
        }).start();
    }

    public static void increment() {
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println("This is :" + Thread.currentThread().getName() + ", value: " + threadLocal.get());
                //将子线程中的数据remove
                threadLocal.remove();
            });
        }
    }
}

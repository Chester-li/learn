package com.learn.oom;

/**
 * @author chaoshuai.li
 * @date 2020/8/10
 * @description
 */
public class UnableCreateNewThread {

    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            System.out.println("========== i : " + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
    //result： Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
    // 线程被创建之后一直sleep。抛出oom异常之后 程序不会终止

}

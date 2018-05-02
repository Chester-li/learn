package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class LazyLoad implements Serializable {
    private static final long serialVersionUID = 1L;

    private LazyLoad() {
    }

    //私有内部类，用时加载
    private static class ThreadHolder {
        private static LazyLoad instance = new LazyLoad();
    }

    public static LazyLoad getInstance() {
        return ThreadHolder.instance;
    }

    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return ThreadHolder.instance;
    }

//    private static LazyLoad instance = null;


//    //懒汉式单例模式 非线程安全
//    public static LazyLoad getInstance() {
//        synchronized (LazyLoad.class) {
//            if (instance == null) { //5
//                try {
//                    Thread.sleep(1); //模拟初始化之前的准备工作
//                    instance = new LazyLoad();//6
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return instance;
//    }

}

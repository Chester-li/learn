package com.demo.staticproxy.common;

public class Wait {


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread1()).start();
        Thread.sleep(1000);
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable {

        public void run() {
            /*
             * 由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器，这里不能用this，
             * 因为在Thread2里面的this和这个Thread1的this不是同一个对象。我们用test.class这
             * 个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对象。
             */
            synchronized (Wait.class) {
                System.out.println("enter Thread1 ...");
                System.out.println("thread1 is waiting");

                try {
                    /*
                     * 线程释放锁有两种方式
                     * 1. 线程执行时超出 synchronized 作用范围
                     * 2. 使用wait方法 线程进入等待队列 （在synchronized关键字管辖的代码内部调用监视器对象的wait方法）
                     */
                    Wait.class.wait();//此处会释放锁 这个线程处于等待状态 且不会继续向下执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ...");
                System.out.println("thread1 is over");
            }
        }
    }

    private static class Thread2 implements Runnable {

        public void run() {
            synchronized (Wait.class) {
                System.out.println("enter Thread2 ...");
                System.out.println("thread2 is waiting");

                /*
                notify 方法不会释放锁，即使thread2 下的sleep方法休息了100ms 但是thread1仍然不会执行
                 */
                //使用notify方法的时候时候不能准确唤醒具体的线程 ，唤醒是由JVM控制，而且不是按照优先级
                Wait.class.notify();//如果不执行notify的话 thread1下面的逻辑不会执行
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on ...");
                System.out.println("thread2 is over");
            }
        }
    }
}

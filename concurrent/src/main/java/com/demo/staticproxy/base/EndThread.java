package com.demo.staticproxy.base;

/**
 * @author chaoshuai.li
 * @date 2020/4/17
 * @description
 */
public class EndThread {

    private static class UThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println(getName() + "is not interrupted " + isInterrupted());
            }
            System.out.println(getName() + "is not interrupted " + isInterrupted());
        }
    }

    /**
     * 在Runnable中可以通过Thread.currentThread()获取线程信息
     */
    private static class URunnable implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "is not interrupted " + Thread.currentThread().isInterrupted());
            }
            System.out.println(Thread.currentThread().getName() + "is not interrupted " + Thread.currentThread().isInterrupted());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        UThread thread = new UThread();
        thread.start();
        Thread.sleep(100);
        thread.interrupt();

        URunnable uRunnable = new URunnable();
        Thread runnableThread = new Thread(uRunnable);
        runnableThread.start();
        Thread.sleep(100);
        runnableThread.interrupt();
    }
}

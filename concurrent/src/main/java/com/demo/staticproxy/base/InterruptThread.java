package com.demo.staticproxy.base;

/**
 * @author chaoshuai.li
 * @date 2020/4/17
 * @description
 */
public class InterruptThread {

    private static class UThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    interrupt();
                    System.out.println(getName() + "is interrupted exception " + isInterrupted());
                    e.printStackTrace();
                }
                System.out.println(getName() + "is not interrupted " + isInterrupted());
            }
            System.out.println(getName() + "is not interrupted " + isInterrupted());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        UThread thread = new UThread();

        thread.start();
        Thread.sleep(500);
        thread.interrupt();

    }
}

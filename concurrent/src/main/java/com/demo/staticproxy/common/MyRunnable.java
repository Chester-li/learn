package com.demo.staticproxy.common;

public class MyRunnable implements Runnable {

    public void run() {
        Thread.currentThread().setName("runnable thread ");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + "  " + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        for (int i = 0; i < 15; i++) {
            System.out.println("main thread : " + i);
        }
    }
}

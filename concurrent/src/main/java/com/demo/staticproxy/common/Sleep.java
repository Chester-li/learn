package com.demo.staticproxy.common;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        SleepThread sleepThread = new SleepThread();
        System.out.println("线程是否存活 ：" + sleepThread.isAlive());
        sleepThread.start();
        //如果主线程 sleep 1s之后再判断子线程是否存活 此时子线程可能已经结束
//        Thread.sleep(1000);
        System.out.println("线程是否存活 ：" + sleepThread.isAlive());
    }
}

class SleepThread extends Thread {
    @Override
    public void run() {
        System.out.println("in run method : " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
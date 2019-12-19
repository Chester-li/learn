package com.demo.staticproxy.common;

public class MyThread extends Thread {

    @Override
    public void run() {
        this.setName("run thread");
        for (int i = 0; i < 7; i++) {
            System.out.println(this + " " + i);
        }
    }

    //按照顺序启动的线程 执行顺序是不确定的
    public static void main(String[] args) {
        new MyThread().start();
        for (int i = 0; i < 15; i++) {
            System.out.println("main thread : " + i);
        }
    }
}

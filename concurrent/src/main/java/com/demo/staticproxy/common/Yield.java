package com.demo.staticproxy.common;


public class Yield {
    public static void main(String[] args) {
        YieldThread yieldThread1 = new YieldThread("yield1");
        yieldThread1.start();

        YieldThread yieldThread2 = new YieldThread("yield2");
        yieldThread2.start();
    }
}

class YieldThread extends Thread {
    YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
            //当是10的倍数的时候就会切换 cpu
            if (i % 10 == 0) {
                //使用yield方法 当前线程进入等待队列 把CPU让给对方
                yield();
            }
        }
    }
}
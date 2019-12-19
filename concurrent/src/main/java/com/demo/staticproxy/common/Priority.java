package com.demo.staticproxy.common;

public class Priority extends Thread {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println("name:" + currentThread.getName() +
                    "  priority :" + currentThread.getPriority() + "  " + 1);
        }
    }

    //多次运行之后 优先级高的线程被最先处理完毕的概率较大 但不是绝对的
    public static void main(String[] args) {
        Priority priority = new Priority();
        priority.setPriority(NORM_PRIORITY);
        priority.start();

        Priority min = new Priority();
        min.setPriority(MIN_PRIORITY);
        min.start();

        Priority max = new Priority();
        max.setPriority(MAX_PRIORITY);
        max.start();
    }
}

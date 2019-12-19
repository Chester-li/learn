package com.demo.staticproxy.common;

public class Join {

    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 5) {
                try {
                    joinThread.start();
                    joinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this + "  " + i);
        }
    }
}
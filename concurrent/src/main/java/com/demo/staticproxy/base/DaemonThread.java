package com.demo.staticproxy.base;

/**
 * @author chaoshuai.li
 * @date 2020/4/17
 * @description 在守护线程中 finally中的代码不一定会被执行
 */
public class DaemonThread {

    private static class UThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(getName() + "is not interrupted " + isInterrupted());
                }
            }finally {
                System.out.println("finally ....");
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        UThread thread = new UThread();
        /**
         * 守护线程 设置要在启动之前
         */
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5);
//        thread.interrupt();

    }
}

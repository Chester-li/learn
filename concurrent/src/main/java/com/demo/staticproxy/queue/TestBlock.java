package com.demo.staticproxy.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlock {

    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

    static class Consumer extends Thread {
        private int index = 0;

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String key = "hello" + index++;
                System.out.println("add ..." + key);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String key1 = "hello" + index++;
                System.out.println("add ..." + key1);
                blockingQueue.add(key);
            }
        }
    }

    static class Producer extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("take : " + blockingQueue.take());
                } catch (InterruptedException e) {
                    System.out.println(JSONObject.toJSON(blockingQueue));
                    e.printStackTrace();
                }
            }
        }
    }

}

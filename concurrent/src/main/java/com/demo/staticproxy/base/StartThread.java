package com.demo.staticproxy.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chaoshuai.li
 * @date 2020/4/17
 * @description
 */
public class StartThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("this is " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("this is " + Thread.currentThread().getName());
        }
    }

    static class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            return "this is MyCallable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        MyCallable callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

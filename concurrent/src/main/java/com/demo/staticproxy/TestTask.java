package com.demo.staticproxy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callable = new Callable() {
            public Object call() throws Exception {
//                Thread.sleep(10000);
                System.out.println("current task:" + Thread.currentThread().getName());
                return "hello";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        ExecutorService executorService = new ThreadPoolExecutor(100, 200, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200));
        executorService.submit(futureTask);
//        try {
//            countDownLatch.await(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException();
//        }
////        Executor executor = Executors.newFixedThreadPool(100);
////        executor.execute(futureTask);
//        try {
//            futureTask.wait(100);
//        } catch (InterruptedException e) {
//            System.out.println(e.getCause());
//        }
//        futureTask.get();
        try {
            System.out.println(futureTask.get(7, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }

}

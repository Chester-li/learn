package com.demo.staticproxy.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaoshuai.li
 * @date 2021/2/23
 * @description
 */
public class Client {

    private static AQSLock aqsLock = new AQSLock();

    private static int count = 0;

    private static void add(){
        aqsLock.lock();
        System.out.println(Thread.currentThread().getName());
        for(int i = 0 ; i < 10000; i++){
//            System.out.println("current thread " + Thread.currentThread().getName() + " , i : " + i);
            count ++;
        }
        aqsLock.unlock();
    }


    private static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static void add2(){
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            for(int i = 0 ; i < 10000; i++){
                count ++;
            }
        }finally {
            reentrantLock.unlock();
        }


    }

    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 20, TimeUnit.NANOSECONDS , new LinkedBlockingDeque<>(1000));
        CountDownLatch countDownLatch  = new CountDownLatch(10);
        for (int i = 10; i > 0; i--) {
            threadPoolExecutor.submit(()->{
                try {
                    Client.add();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        boolean await = countDownLatch.await(10, TimeUnit.SECONDS);
        if(await){
            System.out.println(count);
        }
        threadPoolExecutor.shutdown();

//        Thread t3 = new Thread(Client::add2);
//        Thread t4 = new Thread(Client::add2);
//
//        t3.start();
//        t4.start();
//
//        t3.join();
//        t4.join();
//        System.out.println(count);
    }

}

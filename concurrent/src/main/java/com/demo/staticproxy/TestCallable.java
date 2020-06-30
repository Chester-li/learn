package com.demo.staticproxy;

import java.util.concurrent.Callable;

public class TestCallable {

    static class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("hello world");
            return "hello";
        }
    }

    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        myCallable.call();
    }

}

package com.demo.staticproxy;

public class ThreadLocalTest {

    public static void main(String[] args) throws Exception {
        try {
            throw new RuntimeException("haha");
        }catch (Exception e){
            throw e;
        }finally {
            System.out.println("hello  world");
        }
    }
}

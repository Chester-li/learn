package com.demo.staticproxy.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
    }
}

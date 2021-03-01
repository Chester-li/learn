package com.learn.oom;

/**
 * @author chaoshuai.li
 * @date 2020/8/10
 * @description
 */
public class HeapSpace {

    public static void main(String[] args) {
        //-Xms10m -Xmx10m  初始化堆内存和最大堆内存都是 10m
        byte[] array = new byte[2 * 1024 * 1024];
        //result : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }

}

package com.learn.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @author chaoshuai.li
 * @date 2020/8/10
 * @description
 */
public class DirectBufferMemory {
//   1. 写 NIO 程序经常使用 ByteBuffer 来读取或者写入数据，这是一种基于通道（Channel）与缓冲区（Buffer）的 I/O 方式。它可以使用 Native 函数库直接分配堆外内存，然后通过一个存在在 Java 堆里面的 DirectByteBuffer 对象作为这块内存的引用进行操作。这样能在一些场景中显著提高性能，因为避免了在 Java 堆和 Native 堆中来回复制数据。
//   2. ByteBuffer.allocate(capability) 第一种方式是分配 JVM 堆内存，属于 GC 管辖范围，由于需要拷贝所以速度相对较慢。
//   . ByteBuffer.allocateDirect(capability) 第二种方式是分配 OS 本地内存，不属于 GC 管辖范围，由于不需要内存拷贝，所以速度相对较快。
//   4. 但如果不断分配本地内存，堆内存很少使用，那么 JVM 就不需要执行 GC ，DirectByteBuffer 对象们就不会被回收，这时候堆内存充足，但本地内存可能已经用光了，再次尝试分配本地内存就会出现 OutOfMemory ，程序直接崩溃

    public static void main(String[] args) {
        System.out.println("maxDirectMemory : "+ VM.maxDirectMemory()/(double)1024/ 1024 +"M");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

    //result : Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    //在 NIO 程序中，使用 ByteBuffer.allocateDirect(capability)  分配的是直接内存，可能会导致堆内存溢出

}

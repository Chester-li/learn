package com.learn.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2020/8/10
 * @description
 */
public class GCOverHead {

    public static void main(String[] args) {
        // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            System.out.println("current i = "+i);
            e.printStackTrace();
            throw e;
        }
//        [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7123K->7123K(7168K)] 9171K->9171K(9728K), [Metaspace: 2684K->2684K(1056768K)], 0.0455119 secs] [Times: user=0.10 sys=0.01, real=0.05 secs]
//[Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7125K->7125K(7168K)] 9173K->9173K(9728K), [Metaspace: 2684K->2684K(1056768K)], 0.0520688 secs] [Times: user=0.13 sys=0.00, real=0.05 secs]
        //连续两次GC 没有回收任何内存 GC没有效果，最终抛出 [Full GC (Ergonomics) java.lang.OutOfMemoryError: GC overhead limit exceeded
    }

}

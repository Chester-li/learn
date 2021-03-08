package com.learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2021/3/8
 * @description
 */
public class ConcurrentModification {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("Hello");
        all.add("_");
        all.add("World!!");
        Iterator<String> iterator = all.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if ("Hello".equals(str)) {
//            if ("_".equals(str)) {
//                all.remove(str);
                iterator.remove();
            } else {
                System.out.println(str + " ");
            }
        }
        System.out.println("\n删除\"_\"之后的集合当中的数据为:" + all);
    }
}

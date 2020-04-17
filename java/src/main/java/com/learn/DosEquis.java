package com.learn;

/**
 * @author chaoshuai.li
 * @date 2019/12/31
 * @description
 *
 * 关于三目运算符的类型问题：
 * 1. 如果第二个和第三个操作数具有相同的类型 那么它就是条件表达式的类型
 * 2. 如果第二个操作数据的类型是T T标示byte short char 而另外一个操作数是一个int类型的常量表达式 ，它的值是可以用类型T标示的，那么条件表达式的类型就是T
 * 3. 否则将对操作数类型运用二进制数字提升，而条件表达式的类型就是第二个和第三个操作数被提升之后的类型
 */
public class DosEquis {

    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);
        /**
         * print result:
         * X
         * 88
         */
    }

}

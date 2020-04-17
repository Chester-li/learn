package com.learn;

/**
 * @author chaoshuai.li
 * @date 2019/12/31
 * @description 多重类型的转换规则
 *
 * 如果最初的数值类型是有符号的，那么就执行符号扩展，
 * 如果他是char类型的，不管它将要被转换成什么类型，都执行零扩展
 */
public class MultiCast {

    public static void main(String[] args) {
        System.out.println((int)(char)(byte) -1);
        /**
         * print result:
         * 65535
         */
    }

}

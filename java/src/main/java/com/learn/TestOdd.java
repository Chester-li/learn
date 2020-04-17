package com.learn;

/**
 * @author chaoshuai.li
 * @date 2019/12/31
 * @description 判断一个整数是否是奇数的时候 不要使用取余 == 1 ，而要使用取余不等于0判断
 * 因为：对于一个负数取余之后 是 -1
 *
 * 或者 (i & 1) != 0
 */
public class TestOdd {

    public static void checkOddBy1(int number){
        System.out.println("this is odd, "+( number % 2 == 1));
    }

    public static void checkOddBy2(int number){
        System.out.println("this is odd, "+ (number % 2 != 0));
    }

    public static void main(String[] args) {
        checkOddBy1(-1);
        checkOddBy1(-2);
        checkOddBy1(3);

        checkOddBy2(-1);
        checkOddBy2(-2);
        checkOddBy2(3);
        /**
         * print result:
         *
         * this is odd, false
         * this is odd, false
         * this is odd, true
         * this is odd, true
         * this is odd, false
         * this is odd, true
         */

    }



}

package com.learn;

/**
 * @author chaoshuai.li
 * @date 2019/12/31
 * @description 在使用int类型相乘的时候 可能产生数值溢出
 */
public class TestLongDivision {

    public static void main(String[] args) {
        /**
         * 在使用int类型的数值相乘的时候 临时结果是保存在int类型的数值中
         * 最终再赋值给long类型的变量
         * 此时的结果已经溢出了
         */
        final long MICRO_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long SECOND_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICRO_PER_DAY / SECOND_PER_DAY);

        final long MICRO_PER_DAY_L = 24L * 60 * 60 * 1000 * 1000;
        final long SECOND_PER_DAY_L = 24L * 60 * 60 * 1000;
        System.out.println(MICRO_PER_DAY_L / SECOND_PER_DAY_L);

        /**
         * print result :
         * 5
         * 1000
         */
    }

}

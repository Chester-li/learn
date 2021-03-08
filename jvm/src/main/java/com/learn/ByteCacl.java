package com.learn;

/**
 * @author chaoshuai.li
 * @date 2021/3/3
 * @description
 */
public class ByteCacl {

    class B {
        private int a = 2345;
        private long test(long number){
            long ret = this.a + number;
            return ret;
        }
    }

    private B b = new B();

    public static void main(String[] args) {
        ByteCacl byteCacl = new ByteCacl();
        long number = 11111;
        long ret = byteCacl.b.test(number);
        System.out.println(ret);
    }
}

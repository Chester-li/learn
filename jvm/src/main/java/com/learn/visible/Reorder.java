package com.learn.visible;

/**
 * @author chaoshuai.li
 * @date 2021/2/28
 * @description
 */
public class Reorder {

    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
        while (true) {

            testForReorder();
            if (x == 0 && y == 0 && !flag1) {
                flag1 = true;
                System.out.println("第 " + i + "次 ，x : " + x + ", y:" + y);
            }
            if (x == 0 && y == 1 && !flag2) {
                flag2 = true;
                System.out.println("第 " + i + "次 ，x : " + x + ", y:" + y);
            }
            if (x == 1 && y == 0 && !flag3) {
                flag3 = true;
                System.out.println("第 " + i + "次 ，x : " + x + ", y:" + y);
            }
            if (x == 1 && y == 1 && !flag4) {
                flag4 = true;
                System.out.println("第 " + i + "次 ，x : " + x + ", y:" + y);
            }
            i++;
//            System.out.println("current i : "+ i);
        }
    }

    private static void testForReorder() throws InterruptedException {
        Thread one = new Thread(() -> {
            //one先start
            long start = System.nanoTime();
            long end;
            do{
                end = System.nanoTime();
            }while(start + 1 >= end);
            a = 1;
            x = b;
        });
        Thread two = new Thread(() -> {
            b = 1;
            y = a;
        });

        one.start();
        two.start();
        one.join();
        two.join();
    }


}

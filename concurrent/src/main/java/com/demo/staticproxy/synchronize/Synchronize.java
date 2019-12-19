package com.demo.staticproxy.synchronize;

public class Synchronize implements Runnable {
    private Goods goods = new Goods();

    public void run() {
        synchronized (goods){
            for (int i = 0; i < 10; i++) {
                goods.subtract(10);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + goods.getCount());
            }
        }
    }

    public static void main(String[] args) {
        Synchronize synchronize = new Synchronize();
        new Thread(synchronize).start();
        new Thread(synchronize).start();
    }
}

class Goods {
    private int count = 100;

    public int getCount() {
        return count;
    }

    public void subtract(int number) {
        count -= number;
    }
}
package com.demo.staticproxy.synchronize;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ProducorAndConsumer {

    public static void main(String[] args) {
        Store store = new Store();
        Producor producor1 = new Producor(store, 30);
        Producor producor2 = new Producor(store, 60);
        Consumer producor3 = new Consumer(store, 50);
        Consumer consumer1 = new Consumer(store, 40);
        Consumer consumer2 = new Consumer(store, 10);
        Producor producor4 = new Producor(store, 20);
        Consumer consumer4 = new Consumer(store, 10);

        producor1.start();
        consumer1.start();
        producor2.start();
        consumer2.start();
        producor3.start();
        producor4.start();
        consumer4.start();
    }
}

@Data
@AllArgsConstructor
class Producor extends Thread {
    private Store store;
    private int produceCount;

    @Override
    public void run() {
        try {
            store.produce(produceCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Data
@AllArgsConstructor
class Consumer extends Thread {
    private Store store;
    private int consumeCount;

    @Override
    public void run() {
        try {
            store.consume(consumeCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Data
class Store {
    private int currentGoodsCount = 0;
    private int maxStore = 100;

    public synchronized void produce(int produceCount) throws InterruptedException {
        while (currentGoodsCount + produceCount > maxStore) {
            System.out.println("仓库已满， 等待中 ，" + currentGoodsCount + "生产的个数:" + produceCount);
            this.wait();
        }
        System.out.println("仓库可以继续放入，");
        currentGoodsCount += produceCount;
        System.out.println("当前仓库中物品总数:" + currentGoodsCount);
        this.notifyAll();
    }

    public synchronized void consume(int consumeCount) throws InterruptedException {
        while (currentGoodsCount < consumeCount) {
            System.out.println("仓库库存不足， 等待中 ，" + currentGoodsCount + "，消费的个数：" + consumeCount);
            this.wait();
        }
        System.out.println("仓库已有物品，可取");
        currentGoodsCount -= consumeCount;
        System.out.println("当前仓库中物品总数:" + currentGoodsCount);
        this.notifyAll();
    }
}
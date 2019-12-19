package com.demo.staticproxy.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

public class ProducorAndConsumerByLock {

    public static void main(String[] args) {
        LockStore store = new LockStore();
        LockProducor producor1 = new LockProducor(store, 30, "producer30");
        LockProducor producor2 = new LockProducor(store, 60, "producer60");
        LockConsumer consumer = new LockConsumer(store, 50, "consumer50");
        LockConsumer consumer1 = new LockConsumer(store, 40, "consumer40");
        LockConsumer consumer2 = new LockConsumer(store, 30, "consumer30");
        LockProducor producor4 = new LockProducor(store, 50, "producer50");
        LockConsumer consumer4 = new LockConsumer(store, 20, "consumer20");

        producor1.start();
        consumer1.start();
        producor2.start();
        consumer2.start();
        consumer.start();
        producor4.start();
        consumer4.start();
    }
}

@Data
class LockProducor extends Thread {
    private LockStore store;
    private int produceCount;

    public LockProducor(LockStore store, int produceCount, String name) {
        super(name);
        this.store = store;
        this.produceCount = produceCount;
    }

    @Override
    public void run() {
        store.produce(produceCount);
    }
}

@Data
class LockConsumer extends Thread {
    private LockStore store;
    private int consumeCount;

    public LockConsumer(LockStore store, int consumeCount, String name) {
        super(name);
        this.store = store;
        this.consumeCount = consumeCount;
    }

    @Override
    public void run() {
        store.consume(consumeCount);
    }
}

@Data
class LockStore {
    private int currentGoodsCount = 0;
    private int maxStore = 100;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public void produce(int produceCount) {
        lock.lock();
        try {
            while (currentGoodsCount + produceCount > maxStore) {
                System.out.println(Thread.currentThread().getName() + " 仓库已满， 等待中 ，" + currentGoodsCount + "生产的个数:" + produceCount);
                full.await();
            }
            System.out.println(Thread.currentThread().getName() + " 仓库可以继续放入，");
            currentGoodsCount += produceCount;
            System.out.println(Thread.currentThread().getName() + " 当前仓库中物品总数:" + currentGoodsCount);
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行解锁操作");
            lock.unlock();
        }
    }

    public void consume(int consumeCount) {
        lock.lock();
        try {
            while (currentGoodsCount < consumeCount) {
                System.out.println(Thread.currentThread().getName() + " 仓库库存不足， 等待中 ，" + currentGoodsCount + "，消费的个数：" + consumeCount);
                empty.await();
            }
            System.out.println(Thread.currentThread().getName() + " 仓库已有物品，可取");
            currentGoodsCount -= consumeCount;
            System.out.println(Thread.currentThread().getName() + " 当前仓库中物品总数:" + currentGoodsCount);
            full.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行解锁操作");
            lock.unlock();
        }
    }
}
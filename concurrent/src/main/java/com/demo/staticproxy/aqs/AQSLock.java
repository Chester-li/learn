package com.demo.staticproxy.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author chaoshuai.li
 * @date 2021/2/23
 * @description
 */
public class AQSLock {

    private final Syn syn = new Syn();

    public void lock() {
        syn.acquire(1);
    }

    public void unlock() {
        syn.release(1);
    }

    private static class Syn extends AbstractQueuedSynchronizer {

        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int state = getState() ;
            if (state == 0){
                //hasQueuedPredecessors 判断当前是否有排队等待的线程，如果有的话获取不到锁，该方式为 公平锁，保证先进入队列的先获取锁，将该判断去掉，新来的线程也会竞争锁
                if (!hasQueuedPredecessors() &&
                        compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            //保证锁可以重入
            else if(current == getExclusiveOwnerThread()){
                int reentrant = state + acquires;
                if(reentrant < 0){
                    throw new RuntimeException("超出最大可重入次数的限制");
                }
                setState(reentrant);
                return true;
            }
            return false;
        }


        protected final boolean tryRelease(int releases) {

            //多次重入 state不断累加之后 > 1
            int c = getState() - releases;
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }
    }

}

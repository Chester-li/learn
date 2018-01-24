package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    private AtomicInteger atomicInteger = new AtomicInteger(10);

    @Test
    public void testAtomic() {
        // 1. 自增
        System.out.println(atomicInteger.incrementAndGet());

        // 2. 比较赋值
        //JDK8之前，比较大小并且赋值
        int oldValue = 11;
        int newValue;
        do {
            newValue = Math.max(oldValue, 90);
        } while (atomicInteger.compareAndSet(oldValue, newValue));
        //compareAndSet相当于： if(currentValue == oldValue){currentValue = newValue}
        System.out.println(atomicInteger.get());
        // 3. 直接赋值
        //JDK8之后，比较大小并且赋值 返回的是变更之后的值
        int max = atomicInteger.accumulateAndGet(100, Math::max);
        System.out.println(max);
        //JDK8之后，比较大小并且赋值 返回的是变更之前的值
        max = atomicInteger.getAndAccumulate(110, Math::max);
        System.out.println(max + "  " + atomicInteger.get());
        //按照指定函数更新
        max = atomicInteger.getAndUpdate(a -> (a > 0) ? 1000 : 1001);
        System.out.println(max + "  " + atomicInteger.get());
    }


    private static class Counter {

        private final AtomicInteger number;

        public Counter(int number) {
            this.number = new AtomicInteger(number);
        }

        /**
         * @return true if still can decrease
         */
        public boolean dec() {
            // updateAndGet(fn) executed atomically:
            System.out.println("==before updateAndGet==" + number.get());
            int currentNumber = number.updateAndGet(n -> (n > 0) ? n - 1 : n);
            System.out.println("==after updateAndGet==" + number.get());
            return currentNumber > 0;
        }

        public int getNumber() {
            return number.get();
        }
    }

    private static class Worker implements Runnable {

        private static int nth = 0;

        private final int id = ++nth;
        private Counter counter;

        public Worker(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Starting worker: " + id);
            System.out.println("counter number : " + counter.getNumber() + " , dec():" + counter.dec());
            if (counter.dec()) {
                System.out.printf("Worker %2d saw value: %2d%n", id, counter.number.intValue());
            }
        }
    }

    @Test
    public void testWorker() {
        Counter counter = new Counter(10);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; ++i) {
            executor.execute(new Worker(counter));
        }
//        executor.shutdown();
        System.out.println("Number actually is: " + counter.number);
    }
}

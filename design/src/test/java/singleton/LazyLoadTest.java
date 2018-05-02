package singleton;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyLoadTest {
    @Test
    public void getInstanceByExecutor() {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(new TestRunnable());
        }
    }
}

class TestRunnable implements Runnable {
    public void run() {
        System.out.println(LazyLoad.getInstance().hashCode());
    }
}
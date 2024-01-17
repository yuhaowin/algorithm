package base;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://bugs.openjdk.java.net/browse/JDK-8241094
 * https://mp.weixin.qq.com/s/FJQ5MhB1kMp8lP1NA6q4Vg
 */
public class ThreadPoolResizeTest {
    public static void main(String[] args) throws Exception {
        int tries = 0;
        try {
            for (; ; tries++)
                test();
        } finally {
            System.out.printf("tries = %d%n", tries);
        }
    }

    static void test() throws Exception {
        int minThreads = 1;
        int maxThreads = 5;
        int queueCapacity = 10;

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                minThreads, maxThreads,
                1, TimeUnit.HOURS,
                new LinkedBlockingQueue<Runnable>(queueCapacity));

        CompletableFuture.runAsync(() -> pool.setCorePoolSize(maxThreads));
        CompletableFuture<Void> taskBlocker = new CompletableFuture<>();

        try {
            for (int i = queueCapacity + maxThreads; i-- > 0; ) {
                // following line sometimes throws a RejectedExecutionException
                pool.submit(taskBlocker::join);
            }
        } finally {
            taskBlocker.complete(null);
            pool.shutdown();
        }
    }
}

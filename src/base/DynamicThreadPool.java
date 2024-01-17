package base;

import java.util.concurrent.*;

/**
 * https://mp.weixin.qq.com/s/FJQ5MhB1kMp8lP1NA6q4Vg
 */
public class DynamicThreadPool {

    ThreadPoolExecutor threadPoolExecutor;

    public static void main(String[] args) throws InterruptedException {
        DynamicThreadPool threadPool = new DynamicThreadPool();
        threadPool.buildThreadPool();
        threadPool.print(threadPool.threadPoolExecutor, "init");
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            threadPool.threadPoolExecutor.submit(() -> {
                threadPool.print(threadPool.threadPoolExecutor, "创建任务: " + finalI);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPool.modifyMaxSize(10);
        threadPool.modifyCoreSize(10);
        TimeUnit.SECONDS.sleep(2);
        threadPool.modifyWorkQueueSize(100);
        //Thread.currentThread().join();
        threadPool.print(threadPool.threadPoolExecutor, "end");
    }

    public ThreadPoolExecutor buildThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.MILLISECONDS,
                new ResizeLinkedBlockingQueue<>(10));
        executor.allowCoreThreadTimeOut(true);
        this.threadPoolExecutor = executor;
        return executor;
    }

    public void modifyCoreSize(int num) {
        threadPoolExecutor.setCorePoolSize(num);
    }

    public void modifyMaxSize(int num) {
        threadPoolExecutor.setMaximumPoolSize(num);
    }

    public void modifyWorkQueueSize(int size) {
        ResizeLinkedBlockingQueue<Runnable> queue = (ResizeLinkedBlockingQueue<Runnable>) threadPoolExecutor.getQueue();
        queue.setCapacity(size);
    }

    public void print(ThreadPoolExecutor executor, String name) {
        ResizeLinkedBlockingQueue queue = (ResizeLinkedBlockingQueue) executor.getQueue();
        String message = String.format("%s 核心线程数: %s,最大线程数: %s,活动线程数: %s,完成任务数: %s,队列大小: %s,队列剩余: %s",
                name,
                executor.getCorePoolSize(),
                executor.getMaximumPoolSize(),
                executor.getActiveCount(),
                executor.getCompletedTaskCount(),
                queue.size(),
                queue.remainingCapacity());
        System.out.println(message);

    }
}

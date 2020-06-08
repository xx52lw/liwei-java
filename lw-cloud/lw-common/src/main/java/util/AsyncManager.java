package util;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncManager {

    private static final int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;

    private static ExecutorService executor = new ThreadPoolExecutor(
            corePoolSize, 200,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(102400),
            new BasicThreadFactory.Builder().namingPattern("asyncManager-pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy()) {
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            Threads.printException(r, t);
        }
    };

    private AsyncManager(){}

    private static final AsyncManager instance = new AsyncManager();

    public static AsyncManager getInstance() {
        return instance;
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}

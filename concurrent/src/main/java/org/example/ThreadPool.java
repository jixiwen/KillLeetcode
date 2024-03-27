package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{});
        ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(2);
        Runnable runnable = () -> {};
        scheduledExecutor.schedule(runnable, 2, TimeUnit.SECONDS);
    }
}

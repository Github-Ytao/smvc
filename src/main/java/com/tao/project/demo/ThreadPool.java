package com.tao.project.demo;

import java.util.concurrent.*;

/**
 * @author YangTao
 * @date 2021-11-27 18:42
 */
public class ThreadPool {
    private static ExecutorService pool;

    public static void main(String[] args) {
        pool = new ThreadPoolExecutor(1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 20; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " hello");
            });
        }
    }
}

package com.conCurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Executor Service coreCount:=" + coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        IntStream.range(1, 100).forEach(i -> {
            //System.out.println(i);
            executorService.execute(new Task());
        });
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "===Time==" + System.currentTimeMillis());
        }
    }
}


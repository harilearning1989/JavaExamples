package com.async;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class SequentialThreadMain {
    public static void main(String[] args) {
        //seqRunnableExmple();
        seqCallableExmple();
    }

    private static void seqCallableExmple() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new SequentialThreadCall();
        for (int i = 0; i < 20; i++) {
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                System.out.println(new Date() + "===Thread Name===" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    private static void seqRunnableExmple() {
        SequentialThreadRun sr = new SequentialThreadRun();
        Thread t1 = new Thread(sr);
        t1.setName("FirstThread");
        Thread t2 = new Thread(sr);
        t2.setName("SecondThread");
        Thread t3 = new Thread(sr);
        t3.setName("ThirdThread");
        //Simultaneous Execution
       /* t1.start();
        t2.start();
        t3.start();*/
        try {
            //Sequencial Execution
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SequentialThreadRun implements Runnable {
    @Override
    public void run() {
        System.out.println("In run method " + Thread.currentThread().getName());
    }
}

class SequentialThreadCall implements Callable<String> {
    @Override
    public String call() {
        return Thread.currentThread().getName();
    }
}
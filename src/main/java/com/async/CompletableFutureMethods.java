package com.async;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CompletableFutureMethods {

    /*static CompletableFuture<Void>  runAsync(Runnable runnable)
    static CompletableFuture<Void>  runAsync(Runnable runnable, Executor executor)
    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)*/

    public static void main(String[] args) {
        //runAsyncExample();
        //supplyAsyncExample();
        methodChainFuture();
    }

    private static void methodChainFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<String> supAsyncFutureExecutor = supplyAsync(new SupplyAsyncSupplier("SupplyAsyncSupplier Thread Pool==="), executorService);
        CompletableFuture<String> thenApplyFuture = supAsyncFutureExecutor.thenApply(new ThenApplyFunction());
        try {
            thenApplyFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void supplyAsyncExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<String> supAsyncFuture = supplyAsync(new SupplyAsyncSupplier("SupplyAsyncSupplier"));
        CompletableFuture<String> supAsyncFutureExecutor = supplyAsync(new SupplyAsyncSupplier("SupplyAsyncSupplier Thread Pool==="), executorService);
        try {
            supAsyncFuture.get();
            supAsyncFutureExecutor.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void runAsyncExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<Void> runAsyncFuture = runAsync(new RunAsyncRunnable("RunAsyncRunnable"));
        CompletableFuture<Void> runAsyncFutureExecutor = runAsync(new RunAsyncRunnable("RunAsyncRunnable Thread Pool==="), executorService);
        try {
            runAsyncFuture.get();
            runAsyncFutureExecutor.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class RunAsyncRunnable implements Runnable {
    private String name;

    public RunAsyncRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "===Current Thread===" + Thread.currentThread().getName());
    }
}

class SupplyAsyncSupplier implements Supplier<String> {
    private String name;

    public SupplyAsyncSupplier(String name) {
        this.name = name;
    }

    @Override
    public String get() {
        System.out.println(name + "===Current Thread===" + Thread.currentThread().getName());
        return name;
    }
}

class ThenApplyFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s;
    }
}
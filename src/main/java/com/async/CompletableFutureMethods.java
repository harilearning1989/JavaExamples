package com.async;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.concurrent.CompletableFuture.anyOf;
import static java.util.concurrent.CompletableFuture.allOf;

public class CompletableFutureMethods {

    /*static CompletableFuture<Void>  runAsync(Runnable runnable)
    static CompletableFuture<Void>  runAsync(Runnable runnable, Executor executor)
    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
    static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
    // thenApply() variants
    <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
    <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
    <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)

    static CompletableFuture<Void>	 allOf(CompletableFuture<?>... cfs)
    static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs)
    */

    public static void main(String[] args) {
        //runAsyncExample();
        //supplyAsyncExample();
        //thenMethodChainFuture();
        //acceptMethodChainFuture();
        //combineTwoIndependentFutures();
        //anyOffExample();
        //allOffExample();
        //methodsChaining();
        handleExceptions();
    }

    private static void handleExceptions() {
        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        try {
            System.out.println("Maturity : " + maturityFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void methodsChaining() {
        CompletableFuture.supplyAsync(() -> {
            return "Some result";
        }).thenApply(result -> {
            return result + "===processed result";
        }).thenApply(result -> {
            return result + "===result after further processing";
        }).thenAccept(result -> {
            System.out.println("The result is ===" + result);
        });
    }

    private static void allOffExample() {
        CompletableFuture<String> future1 = supplyAsync(() -> "Result of Future 1");
        CompletableFuture<String> future2 = supplyAsync(() -> "Result of Future 2");
        CompletableFuture<String> future3 = supplyAsync(() -> "Result of Future 3");

        CompletableFuture<Void> anyOfFuture = allOf(future1, future2, future3);

        try {
            System.out.println(anyOfFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void anyOffExample() {
        CompletableFuture<String> future1 = supplyAsync(() -> "Result of Future 1");
        CompletableFuture<String> future2 = supplyAsync(() -> "Result of Future 2");
        CompletableFuture<String> future3 = supplyAsync(() -> "Result of Future 3");

        CompletableFuture<Object> anyOfFuture = anyOf(future1, future2, future3);

        try {
            System.out.println(anyOfFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void combineTwoIndependentFutures() {
        System.out.println("Retrieving weight.");
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 65.0;
        });

        System.out.println("Retrieving height.");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 177.8;
        });

        System.out.println("Calculating BMI.");
        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm / 100;
                    return weightInKg / (heightInMeter * heightInMeter);
                });

        try {
            System.out.println("Your BMI is - " + combinedFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void acceptMethodChainFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<String> supAsyncFutureExecutor = supplyAsync(new SupplyAsyncSupplier("SupplyAsyncSupplier Thread Pool==="), executorService);
        CompletableFuture<Void> acceptApplyFuture = supAsyncFutureExecutor.thenAccept(new ThenAcceptConsumer());
        try {
            acceptApplyFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void thenMethodChainFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<String> supAsyncFutureExecutor = supplyAsync(new SupplyAsyncSupplier("SupplyAsyncSupplier Thread Pool==="), executorService);
        CompletableFuture<String> thenApplyFuture = supAsyncFutureExecutor.thenApply(new ThenApplyFunction());
        try {
            thenApplyFuture.get();
        } catch (InterruptedException | ExecutionException e) {
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
        } catch (InterruptedException | ExecutionException e) {
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
        } catch (InterruptedException | ExecutionException e) {
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
    public String apply(String name) {
        System.out.println(name + "===Current Thread===" + Thread.currentThread().getName());
        return name;
    }
}

class ThenAcceptConsumer implements Consumer<String> {
    @Override
    public void accept(String name) {
        System.out.println(name + "===Current Thread===" + Thread.currentThread().getName());
    }
}
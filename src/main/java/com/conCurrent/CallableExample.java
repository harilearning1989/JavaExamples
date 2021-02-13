package com.conCurrent;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        //futureDemo();
        //futureDemo1();
        callableLambdaFuture();
        callableLambdaCompletableFuture();
    }

    public static void callableLambdaCompletableFuture() {
        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> sumCallable = () -> {   // Lambda Expression
            Thread.sleep(11000);
            return 100;
        };
        Callable<String> nameCallable = () -> {   // Lambda Expression
            return "Hello Callable";
        };
        CompletableFuture<Integer> futureInt = executor.submit(sumCallable);
        CompletableFuture<String> futureStr = executor.submit(nameCallable);
        try {
            Integer resultInt = futureInt.get(); //wait for a thread to complete
            String resultStr = futureStr.get(); //wait for a thread to complete
            System.out.println("resultInt=:" + resultInt);
            System.out.println("resultStr=:" + resultStr);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();*/
    }
    public static void callableLambdaFuture() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> sumCallable = () -> {   // Lambda Expression
            Thread.sleep(11000);
            return 100;
        };
        Callable<String> nameCallable = () -> {   // Lambda Expression
            return "Hello Callable";
        };
        Future<Integer> futureInt = executor.submit(sumCallable);
        Future<String> futureStr = executor.submit(nameCallable);
        try {
            Integer resultInt = futureInt.get(); //wait for a thread to complete
            String resultStr = futureStr.get(); //wait for a thread to complete
            System.out.println("resultInt=:" + resultInt);
            System.out.println("resultStr=:" + resultStr);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    public static void futureDemo() {
        System.out.println("CallableExample Hello World");
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "Callable Demo";
            }
        };
        int countProcess = Runtime.getRuntime().availableProcessors();
        System.out.println("Total Threads:=" + countProcess);
        ExecutorService executorService = Executors.newFixedThreadPool(countProcess);
        Future<String> future = executorService.submit(task);
        try {
            System.out.println("The Value of Future is==:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Available Total Threads:=" + countProcess);
    }

    public static void futureDemo1() {
        SquareCalculator squareCalculator = new SquareCalculator();

        int countProcess = Runtime.getRuntime().availableProcessors();
        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            System.out.println("Available Threads:=" + Runtime.getRuntime().availableProcessors());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer result1 = null;
        Integer result2 = null;
        try {
            result1 = future1.get();
            result2 = future2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println(result1 + " and " + result2);

        //squareCalculator.shutdown();
    }


}

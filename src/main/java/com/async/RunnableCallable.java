package com.async;
//com.demo.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class RunnableCallable {

    public static void main(String[] args) {
        //runnableExample();
        completableFuture();
        //runnableCallableLambda();
        //multipleCallable();
    }

    private static void multipleCallable() {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    return "t1";
                },
                () -> "t2",
                () -> {
                    TimeUnit.SECONDS.sleep(5);
                    return "t3";
                },
                () -> "t4"
        );

        try {
            executor.invokeAll(callables)
                    .parallelStream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void completableFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        CompletableFuture<Void> empRunFuture =
                runAsync(new EmployeeRunnable("EmployeeRunnable runAsync"), executorService);
        CompletableFuture<Void> deptRunFuture =
                runAsync(new DepartmentRunnable("DepartmentRunnable runAsync"), executorService);
        CompletableFuture<Void> stdRunFuture =
                runAsync(new StudentRunnable("StudentRunnable runAsync"), executorService);

        CompletableFuture<String> stdSupplier =
                supplyAsync(new StudentSupplier("StudentSupplier supplyAsync"), executorService);
        CompletableFuture<String> empSupplier =
                supplyAsync(new EmployeeSupplier("EmployeeSupplier supplyAsync"), executorService);
        CompletableFuture<String> deptSupplier =
                supplyAsync(new DepartmentSupplier("DepartmentSupplier supplyAsync"), executorService);

        CompletableFuture<List<String>> stdSupplierList =
                supplyAsync(new StudentSupplierList(), executorService);
        try {
            String empCall = stdSupplier.get().toString();
            String stdCall = empSupplier.get().toString();
            String deptCall = deptSupplier.get().toString();
            List<String> list = stdSupplierList.get();
            System.out.println("stdSupplierList===" + list);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void runnableExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        executorService.execute(new EmployeeRunnable("Hello EmployeeRunnable"));
        executorService.execute(new DepartmentRunnable("Hello DepartmentRunnable"));
        executorService.execute(new StudentRunnable("Hello StudentRunnable"));

        Future empFuture = executorService.submit(new EmployeeCallable("EmployeeCallable"));
        Future stdFuture = executorService.submit(new StudentCallable("StudentCallable"));
        Future deptFuture = executorService.submit(new DepartmentCallable("DepartmentCallable"));
        try {
            String empCall = empFuture.get().toString();
            String stdCall = stdFuture.get().toString();
            String deptCall = deptFuture.get().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void runnableCallableLambda() {
        Runnable runnable = () -> {
            System.out.println("Runnable Example");
        };
        runnable.run();
        Callable<String> callable = () -> {
            System.out.println("Callable Example");
            return "Callable Example";
        };
        try {
            String callStr = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Callable<Integer> callableObj = () -> {
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result = 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = " + result);
    }
}


class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return new Random().nextInt();
    }
}

class EmployeeRunnable implements Runnable {
    private String name;

    public EmployeeRunnable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public void run() {
        System.out.println("Employee Runnable===" + name + "===Thread Name===" + Thread.currentThread().getName());
    }
}

class DepartmentRunnable implements Runnable {
    private String name;

    public DepartmentRunnable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Department Runnable===" + name + "===Thread Name===" + Thread.currentThread().getName());
    }
}

class StudentRunnable implements Runnable {
    private String name;

    public StudentRunnable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public void run() {
        System.out.println("Student Runnable===" + name + "===Thread Name===" + Thread.currentThread().getName());
    }
}

class EmployeeCallable implements Callable<String> {
    private String name;

    public EmployeeCallable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String call() throws Exception {
        System.out.println("EmployeeCallable===" + name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class DepartmentCallable implements Callable<String> {
    private String name;

    public DepartmentCallable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String call() throws Exception {
        System.out.println("DepartmentCallable===" + name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class StudentCallable implements Callable<String> {
    private String name;

    public StudentCallable(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String call() throws Exception {
        System.out.println("StudentCallable===" + name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class DepartmentSupplier implements Supplier<String> {
    private String name;

    public DepartmentSupplier(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String get() {
        System.out.println(name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class EmployeeSupplier implements Supplier<String> {
    private String name;

    public EmployeeSupplier(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String get() {
        System.out.println(name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class StudentSupplier implements Supplier<String> {
    private String name;

    public StudentSupplier(String hello_runnable) {
        this.name = hello_runnable;
    }

    @Override
    public String get() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "===Thread Name===" + Thread.currentThread().getName());
        return name;
    }
}

class StudentSupplierList implements Supplier<List<String>> {
    @Override
    public List<String> get() {
        return Arrays.asList("a", "b");
    }
}

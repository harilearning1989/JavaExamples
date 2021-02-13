package com.lambda;

import com.oracle.CountriesDemo;
import com.oracle.SalesOrderDemo;
import com.oracle.model.Countries;
import com.oracle.model.SalesOrder;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LambdaExpressions {

    public static void main(String[] args) {
        functionalInterfaces();
        //completableFutureDemo();
    }

    private static void functionalInterfaces() {
        functionInterface();
    }

    private static void functionInterface() {
        //Function,Predicate,Supplier,Consumer
        /*Function<String, Integer> strLength = s -> {
            Optional<String> optStr = Optional.ofNullable(s).filter(f -> f.trim().length() > 0);
            return optStr.isPresent() ? optStr.get().length() : 0;
        };
        System.out.println(strLength.apply("HariReddy"));
        System.out.println(strLength.apply(null));
        System.out.println(strLength.apply("  "));*/

        /*List<SalesOrder> salesOrders = SalesOrderDemo.getSalesOrderData();
        salesOrders.forEach(f -> System.out.println(f.getRegion()));*/
        List<Countries> countriesList = CountriesDemo.getCountriesDetails();
        countriesList.forEach(f -> System.out.println(f.getRegion()));

    }

    public static CompletableFuture<Integer> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private static Integer calculatePrice(String product) {
        return product.length();
    }

    private static String getDataById(int id) {
        System.out.println("getDataById: " + Thread.currentThread().getName());
        return "Data:" + id;
    }

    private static String sendData(String data) {
        System.out.println("sendData: " + Thread.currentThread().getName());
        System.out.println(data);
        return data;
    }

    private static void completableFutureDemo() {
        //https://www.concretepage.com/java/java-8/java-completablefuture-supplyasync
        CompletableFuture<List<SalesOrder>> completableFuture
                = CompletableFuture.supplyAsync(() -> SalesOrderDemo.getSalesOrderData());
        List<SalesOrder> salesOrdersImmutable = Collections.emptyList();
        try {
            List<SalesOrder> salesOrders = completableFuture.get();
            salesOrdersImmutable = salesOrders;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        salesOrdersImmutable.forEach(f -> System.out.println(f.getRegion()));
        int i = 10;
        String str = "Hari";
        CompletableFuture<String> cfInt = CompletableFuture.supplyAsync(() -> getDataById(i));
        CompletableFuture<Integer> cfStr = CompletableFuture.supplyAsync(() -> {
            CompletableFuture<Integer> intValFuture = getPriceAsync(str);
            int intVal = 0;
            try {
                intVal = intValFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return intVal;
        });
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> getDataById(10))
                .thenApply(data -> sendData(data));
    }
}

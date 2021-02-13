package com.conCurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class RunnableDemo {
    public static void main(String[] args) {
        final List<Book> list = Arrays.asList(new Book(1, "Ramayan"), new Book(2, "Mahabharat"));
        int countProcess = Runtime.getRuntime().availableProcessors();
        System.out.println("countProcess:=" + countProcess);
        ExecutorService service = Executors.newFixedThreadPool(countProcess);
        Runnable r1 = () -> list.forEach(Book::print);
        service.execute(r1);
        Runnable r2 = () -> {
            Consumer<Book> style = (Book b) -> System.out.println("Book Id:" + b.getId() + ", Book Name:" + b.getName());
            list.forEach(style);
        };
        service.execute(r2);
    }

}

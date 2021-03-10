package com.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SummaryStatistics {

    public static void main(String[] args) {
        intSummaryStatistics();
    }

    private static void intSummaryStatistics() {
        List<Integer> primes = Arrays.asList(1, 2, 3, 4, 5, 33, 22, 32, 43, 78, 3, 2, 22);
        IntSummaryStatistics stats = primes.stream().mapToInt(n -> n).summaryStatistics();
        System.out.println("Max value===" + stats.getMax() + "===Min Value:=" + stats.getMin()
                + "===Avg Value:==" + stats.getAverage() + "===Count:=" + stats.getCount() + "==Sum:==" + stats.getSum());
    }
}

package com.stats;

import com.github.csv.ReadCSVFiles;
import com.github.dto.CropInsuranceDTO;

import java.util.*;
import java.util.stream.Collectors;

public class SummaryStatistics {

    public static void main(String[] args) {
        //intSummaryStatistics();
        List<CropInsuranceDTO> cropDetails = ReadCSVFiles.readCropDetails("csv/crop_insurance.csv");
        groupByFunctions(cropDetails);
    }

    private static void intSummaryStatistics() {
        List<Integer> primes = Arrays.asList(1, 2, 3, 4, 5, 33, 22, 32, 43, 78, 3, 2, 22);
        IntSummaryStatistics stats = primes.stream().mapToInt(n -> n).summaryStatistics();
        System.out.println("Max value===" + stats.getMax() + "===Min Value:=" + stats.getMin()
                + "===Avg Value:==" + stats.getAverage() + "===Count:=" + stats.getCount() + "==Sum:==" + stats.getSum());
    }

    private static void groupByFunctions(List<CropInsuranceDTO> cropDetails) {
        Map<String, List<CropInsuranceDTO>> basedOnMandal = Optional.ofNullable(cropDetails)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(CropInsuranceDTO::getMandalName));
        Optional.ofNullable(basedOnMandal).orElseGet(Collections::emptyMap)
                .forEach((k, v) -> {
                    DoubleSummaryStatistics amountStats = Optional.ofNullable(v)
                            .orElseGet(Collections::emptyList)
                            .stream()
                            .filter(Objects::nonNull)
                            .mapToDouble((x) -> x.getClaimAmountRs())
                            .summaryStatistics();
                    System.out.println(k + "==" + v.size() + "==Max Value==" + amountStats.getMax() + "==Min Value==" + amountStats.getMin());
                });
        DoubleSummaryStatistics amountStats = Optional.ofNullable(cropDetails)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble((x) -> x.getClaimAmountRs())
                .summaryStatistics();
        System.out.println("Max==" + amountStats.getMax() + "==Min==" + amountStats.getMin() +
                "==Avg==" + amountStats.getAverage() + "==Sum==" + amountStats.getSum());
    }
}


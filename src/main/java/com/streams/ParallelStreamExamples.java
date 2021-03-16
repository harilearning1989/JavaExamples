package com.streams;

import com.github.DownloadGitHubFiles;
import com.github.dto.CropInsuranceDTO;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class ParallelStreamExamples {

    public static String fileBefore = "D:/DataFiles/Downloaded/";

    public static void main(String[] args) {
        //basicStream();
        CompletableFuture<List<CropInsuranceDTO>> cropFuture =
                CompletableFuture.supplyAsync(() -> readCropDetails("csv/crop_insurance.csv"));
        try {
            List<CropInsuranceDTO> cropList = cropFuture.get();
            //processParallelData(cropList);
            countTheFruits();
            long startTime = System.currentTimeMillis();
            countTheVillages(cropList);
            long endTime = System.currentTimeMillis();
            System.out.println("Stream Execution time taken==" + (endTime - startTime));

            startTime = System.currentTimeMillis();
            countTheVillagesParallel(cropList);
            endTime = System.currentTimeMillis();
            System.out.println("Parallel Stream Execution time taken==" + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void countTheVillagesParallel(List<CropInsuranceDTO> cropList) {
        Map<String, Long> countVillage =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(CropInsuranceDTO::getVillageName, Collectors.counting()));
        /*countVillage.forEach((k, v) -> {
            System.out.println("Vill Name==" + k + "==Count==" + v);
        });*/

        Map<String, Long> sortByValue = new LinkedHashMap<>();
        countVillage.entrySet().parallelStream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> sortByValue.put(e.getKey(), e.getValue()));
        sortByValue.forEach((k, v) -> {
            //System.out.println("Vill Name==" + k + "==Count==" + v);
        });

        Map<String, Long> sortByKey = new LinkedHashMap<>();
        countVillage.entrySet().parallelStream()
                .sorted(Map.Entry.<String, Long>comparingByKey()
                        .reversed()).forEachOrdered(e -> sortByKey.put(e.getKey(), e.getValue()));
        sortByKey.forEach((k, v) -> {
            //System.out.println("Vill Name==" + k + "==Count==" + v);
        });
    }

    private static void countTheVillages(List<CropInsuranceDTO> cropList) {
        Map<String, Long> countVillage =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(CropInsuranceDTO::getVillageName, Collectors.counting()));
        /*countVillage.forEach((k, v) -> {
            System.out.println("Vill Name==" + k + "==Count==" + v);
        });*/

        Map<String, Long> sortByValue = new LinkedHashMap<>();
        countVillage.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> sortByValue.put(e.getKey(), e.getValue()));
        sortByValue.forEach((k, v) -> {
            //System.out.println("Vill Name==" + k + "==Count==" + v);
        });

        Map<String, Long> sortByKey = new LinkedHashMap<>();
        countVillage.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey()
                        .reversed()).forEachOrdered(e -> sortByKey.put(e.getKey(), e.getValue()));
        sortByKey.forEach((k, v) -> {
            //System.out.println("Vill Name==" + k + "==Count==" + v);
        });
    }

    private static void countTheFruits() {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = Optional.ofNullable(items)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    private static void processParallelData(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> groupByVillage = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(CropInsuranceDTO::getVillageName));
        groupByVillage.forEach((k, v) -> {
            //System.out.println(k + "===" + v.size());
        });
        Map<String, SortedSet<CropInsuranceDTO>> maxAndMinClaim = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(CropInsuranceDTO::getVillageName,
                        toCollection(() -> new TreeSet<>(comparingDouble(CropInsuranceDTO::getClaimAmountRs)))));
        Map<String, SortedSet<CropInsuranceDTO>> villMaxMin = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(CropInsuranceDTO::getVillageName,
                        toCollection(() -> new TreeSet<>(comparingDouble(CropInsuranceDTO::getClaimAmountRs)))));
        villMaxMin.forEach((k, v) -> {
            //System.out.println(k + "==First==" + v.first().getNameOfTheBeneficiary() + "==Last==" + v.last().getNameOfTheBeneficiary());
        });
        Map<String, List<CropInsuranceDTO>> statsClaim = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(CropInsuranceDTO::getVillageName));
        statsClaim.forEach((k, v) -> {
            DoubleSummaryStatistics villStats = Optional.ofNullable(v)
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .filter(Objects::nonNull)
                    .mapToDouble(CropInsuranceDTO::getClaimAmountRs)
                    .summaryStatistics();
            System.out.println(k + "==Max==" + villStats.getMax() + "==Min==" + villStats.getMin() +
                    "==Average==" + villStats.getAverage() + "==Count==" + villStats.getCount() + "==Sum==" + villStats.getSum());
        });
    }

    public static List<CropInsuranceDTO> readCropDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static void basicStream() {
        long startTime = System.currentTimeMillis();
        int total = IntStream.range(1, 200000).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken for the Stream:==" + (endTime - startTime));
        System.out.println("=============================================");
        startTime = System.currentTimeMillis();
        total = IntStream.range(1, 200000).parallel().sum();
        endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken for the Stream:==" + (endTime - startTime));
    }
}

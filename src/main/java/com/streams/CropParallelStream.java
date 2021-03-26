package com.streams;

import com.github.DownloadGitHubFiles;
import com.github.dto.CropInsuranceDTO;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class CropParallelStream {
    public static void main(String[] args) {
        try {
            DownloadGitHubFiles.downloadFile("csv/crop_insurance.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cropFileLocation = "D:/DataFiles/Downloaded/csv/crop_insurance.csv";
        List<CropInsuranceDTO> cropList = getCropDetails(cropFileLocation);
        cropList.add(null);
        cropList.add(new CropInsuranceDTO());

        //findTheMaxClaim(cropList);
        //findTheMinClaim(cropList);
        //countTheCropsByMandal(cropList);
        //averageClaimAmount(cropList);
        //totalClaimAmount(cropList);

        //claimSummaryStats(cropList);

        //findMaxClaimRow(cropList);
        //findMinClaimRow(cropList);

        //groupByMandals(cropList);
        //groupByMandalStats(cropList);
        //groupBySumOfClaims(cropList);
        //groupByMinClaimOfEachMandal(cropList);
        //groupByMaxClaimOfEachMandal(cropList);
        //groupByAvgClaimOfEachMandal(cropList);
        //groupByCountClaimOfEachMandal(cropList);
        //groupByMadalMax10Claims(cropList);
        //groupByMadalMin10Claims(cropList);
        //groupByMadalMaxDist10Claims(cropList);
        //groupByMadalMinDist10Claims(cropList);
        //groupByMandalClaimBetween(cropList);
        //groupByMandalClaimBetweenDetail(cropList);
        //groupByMandalClaimGreaterThan(cropList);
        //17 21
        groupByVillCount(cropList);

        //getDistinctMandals(cropList);
        //getVillageAndName(cropList);
        //getAllCropsMoreThanLakh(cropList);
        //getAllCropsMoreThanLakhCount(cropList);

        //filterAndSort(cropList);
        //filterAndSortReverse(cropList);
        //filterAndSortIgnoreCase(cropList);
        //filterAndSortNullsLast(cropList);
    }

    private static void groupByVillCount(List<CropInsuranceDTO> cropList) {
        Map<String, Long> groupByVillCounting = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getVillageName() != null)
                .collect(groupingBy(CropInsuranceDTO::getVillageName, counting()));
        groupByVillCounting.forEach((k, v) -> System.out.println(k + "====" + v));
    }

    private static void groupByMandalClaimGreaterThan(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> groupByTop10 =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.parallelStream()
                                        .sorted(comparing(CropInsuranceDTO::getClaimAmountRs).reversed())
                                        .filter(f -> f.getClaimAmountRs() >= 50000)
                                        .collect(toList()))));
        groupByTop10.forEach((k, v) -> {
            System.out.println("Key is===" + k);
            v.forEach(f -> System.out.println(f.getClaimAmountRs()));
        });
    }

    private static void groupByMandalClaimBetweenDetail(List<CropInsuranceDTO> cropList) {
        Map<String, List<VillageAndName>> claimBetweenDetail =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .filter(f -> f.getClaimAmountRs() >= 80000 && f.getClaimAmountRs() <= 100000)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.stream()
                                        .map(m -> {
                                            VillageAndName vill = new VillageAndName();
                                            vill.setClaim(m.getClaimAmountRs());
                                            vill.setName(m.getNameOfTheBeneficiary());
                                            vill.setVillage(m.getVillageName());
                                            return vill;
                                        })
                                        .sorted(comparing(VillageAndName::getClaim).reversed())
                                        .collect(toList()))));
        claimBetweenDetail.forEach((k, v) -> {
            System.out.println("Mandal is ==" + k);
            v.forEach(f -> {
                System.out.println(f.getClaim());
            });
        });
    }

    private static void groupByMandalClaimBetween(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> claimBetween = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 80000 && f.getClaimAmountRs() <= 100000)
                .collect(groupingBy(CropInsuranceDTO::getMandalName, toList()));
        claimBetween.forEach((k, v) -> {
            System.out.println("===Mandal==" + k);
            v.forEach(f -> System.out.println(f.getClaimAmountRs()));
        });
    }

    private static void groupByMadalMinDist10Claims(List<CropInsuranceDTO> cropList) {
        Map<String, List<Double>> groupByTop10 =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.stream()
                                        .map(CropInsuranceDTO::getClaimAmountRs)
                                        .sorted()
                                        .distinct()
                                        .limit(10)
                                        .collect(toList()))));
        groupByTop10.forEach((k, v) -> {
            System.out.println("Key is===" + k);
            v.forEach(f -> System.out.println(f));
        });
    }

    private static void groupByMadalMaxDist10Claims(List<CropInsuranceDTO> cropList) {
        Map<String, List<Double>> groupByTop10 =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.stream()
                                        .map(CropInsuranceDTO::getClaimAmountRs)
                                        .sorted(reverseOrder())
                                        .distinct()
                                        .limit(10)
                                        .collect(toList()))));
        groupByTop10.forEach((k, v) -> {
            System.out.println("Key is===" + k);
            v.forEach(f -> System.out.println(f));
        });
    }

    private static void groupByMadalMin10Claims(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> groupByTop10 =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.stream()
                                        .sorted(comparing(CropInsuranceDTO::getClaimAmountRs))
                                        .limit(10).collect(toList()))));
        groupByTop10.forEach((k, v) -> {
            System.out.println("Key is===" + k);
            v.forEach(f -> System.out.println(f.getClaimAmountRs()));
        });
    }

    private static void groupByMadalMax10Claims(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> groupByTop10 =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName,
                                collectingAndThen(toList(), l -> l.stream()
                                        .sorted(comparing(CropInsuranceDTO::getClaimAmountRs).reversed())
                                        .limit(10).collect(toList()))));
        groupByTop10.forEach((k, v) -> {
            System.out.println("Key is===" + k);
            v.forEach(f -> System.out.println(f.getClaimAmountRs()));
        });
    }

    private static void filterAndSortNullsLast(List<CropInsuranceDTO> cropList) {
        List<CropInsuranceDTO> cropData = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .sorted(comparing(CropInsuranceDTO::getNameOfTheBeneficiary, nullsLast(String::compareToIgnoreCase)))
                .collect(toList());
        cropData.forEach(f -> System.out.println(f.getNameOfTheBeneficiary()));
    }

    private static void filterAndSortIgnoreCase(List<CropInsuranceDTO> cropList) {
        List<CropInsuranceDTO> cropData = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .sorted(comparing(CropInsuranceDTO::getNameOfTheBeneficiary, String::compareToIgnoreCase))
                .collect(toList());
        cropData.forEach(f -> System.out.println(f.getNameOfTheBeneficiary()));
    }

    private static void filterAndSortReverse(List<CropInsuranceDTO> cropList) {
        List<CropInsuranceDTO> cropData = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .sorted(comparing(CropInsuranceDTO::getNameOfTheBeneficiary).reversed())
                .collect(toList());
        cropData.forEach(f -> System.out.println(f.getNameOfTheBeneficiary()));
    }

    private static void filterAndSort(List<CropInsuranceDTO> cropList) {
        List<CropInsuranceDTO> cropData = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .sorted(comparing(CropInsuranceDTO::getNameOfTheBeneficiary))
                .collect(toList());
        cropData.forEach(f -> System.out.println(f.getNameOfTheBeneficiary()));
    }

    private static void getAllCropsMoreThanLakhCount(List<CropInsuranceDTO> cropList) {
        long count = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .count();
        System.out.println("More Than Lakhs Claims==" + count);
    }

    private static void getAllCropsMoreThanLakh(List<CropInsuranceDTO> cropList) {
        List<CropInsuranceDTO> cropData = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getClaimAmountRs() >= 100000)
                .collect(toList());
        cropData.forEach(f -> System.out.println(f.getNameOfTheBeneficiary()));
    }

    private static void getVillageAndName(List<CropInsuranceDTO> cropList) {
        List<VillageAndName> villName = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getVillageName() != null && f.getNameOfTheBeneficiary() != null)
                .map(m -> {
                    VillageAndName vill = new VillageAndName();
                    vill.setName(m.getNameOfTheBeneficiary());
                    vill.setVillage(m.getVillageName());
                    return vill;
                })
                .collect(toList());
        villName.forEach(f -> {
            System.out.println("Vill Name===" + f.getVillage() + "===Beneficiary Name===" + f.getName());
        });
    }

    private static void getDistinctMandals(List<CropInsuranceDTO> cropList) {
        List<String> mandals = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .map(CropInsuranceDTO::getMandalName)
                .filter(Objects::nonNull)
                .distinct()
                .collect(toList());
        mandals.forEach(System.out::println);
    }

    private static void groupByCountClaimOfEachMandal(List<CropInsuranceDTO> cropList) {
        Map<String, Long> claimCountByMandal = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName, counting()));
        claimCountByMandal.forEach((k, v) -> {
            System.out.println(k + "====" + v);
        });
    }

    private static void groupByAvgClaimOfEachMandal(List<CropInsuranceDTO> cropList) {
        Map<String, Double> avgClaimByMandal = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName, averagingDouble(CropInsuranceDTO::getClaimAmountRs)));
        avgClaimByMandal.forEach((k, v) -> {
            System.out.println(k + "====" + v);
        });
    }

    private static void groupByMaxClaimOfEachMandal(List<CropInsuranceDTO> cropList) {
        Map<String, Optional<CropInsuranceDTO>> maxClaimByMandal = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName,
                        maxBy(comparingDouble(CropInsuranceDTO::getClaimAmountRs))));
        maxClaimByMandal.forEach((k, v) -> {
            System.out.println(k + "====" + v.get().getClaimAmountRs());
        });
    }

    private static void groupByMinClaimOfEachMandal(List<CropInsuranceDTO> cropList) {
        Map<String, Optional<CropInsuranceDTO>> minClaimByMandal = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName,
                        minBy(comparingDouble(CropInsuranceDTO::getClaimAmountRs))));
        minClaimByMandal.forEach((k, v) -> {
            System.out.println(k + "====" + v.get().getClaimAmountRs());
        });
    }

    private static void groupBySumOfClaims(List<CropInsuranceDTO> cropList) {
        Map<String, Double> sumOfDept = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName, summingDouble(CropInsuranceDTO::getClaimAmountRs)));
        sumOfDept.forEach((k, v) -> {
            System.out.println(k + "====" + v);
        });
    }

    private static void findMinClaimRow(List<CropInsuranceDTO> cropList) {
        CropInsuranceDTO minClaim = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .max(comparing(CropInsuranceDTO::getClaimAmountRs))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Maximum CropInsuranceDTO :==" + minClaim);
    }

    private static void findMaxClaimRow(List<CropInsuranceDTO> cropList) {
        CropInsuranceDTO maxClaim = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .max(comparing(CropInsuranceDTO::getClaimAmountRs))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Maximum CropInsuranceDTO :==" + maxClaim);
    }

    private static void groupByMandalStats(List<CropInsuranceDTO> cropList) {
        Map<String, DoubleSummaryStatistics> byMandalStats = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> f.getMandalName() != null)
                .collect(groupingBy(CropInsuranceDTO::getMandalName,
                        summarizingDouble(CropInsuranceDTO::getClaimAmountRs)));
        byMandalStats.forEach((k, v) -> {
            System.out.println(k + "===" + v.getMax() + "==min==" + v.getMin());
        });
    }

    private static void groupByMandals(List<CropInsuranceDTO> cropList) {
        Map<String, List<CropInsuranceDTO>> byMandal =
                Optional.ofNullable(cropList)
                        .orElseGet(Collections::emptyList)
                        .parallelStream()
                        .filter(Objects::nonNull)
                        .filter(f -> f.getMandalName() != null)
                        .collect(groupingBy(CropInsuranceDTO::getMandalName, toList()));

        byMandal.forEach((k, v) -> {
            System.out.println(k + "===" + v.size());
        });
    }

    private static void claimSummaryStats(List<CropInsuranceDTO> cropList) {
        DoubleSummaryStatistics doubleSummaryStatistics = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .filter(f -> {
                    if (f.getClaimAmountRs() > 0) {
                        return true;
                    }
                    return false;
                })
                .collect(summarizingDouble(CropInsuranceDTO::getClaimAmountRs));
        System.out.println("DoubleSummaryStatistics:== " + doubleSummaryStatistics);
    }

    private static void totalClaimAmount(List<CropInsuranceDTO> cropList) {
        double total = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .collect(summingDouble(CropInsuranceDTO::getClaimAmountRs));
        System.out.println("Total Claim Amount:==" + total);
    }

    private static void averageClaimAmount(List<CropInsuranceDTO> cropList) {
        double average = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .collect(averagingDouble(CropInsuranceDTO::getClaimAmountRs));
        System.out.println("Average Amount===" + average);
    }

    private static void countTheCropsByMandal(List<CropInsuranceDTO> cropList) {
        long count = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .map(CropInsuranceDTO::getMandalName)
                .filter(Objects::nonNull)
                .filter(f -> f.equalsIgnoreCase("bukkapatnam"))
                .count();
        System.out.println("No of Claims Bukkapatnam:==" + count);
    }

    private static void findTheMinClaim(List<CropInsuranceDTO> cropList) {
        double minAmount = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .mapToDouble(CropInsuranceDTO::getClaimAmountRs)
                .filter(d -> d > 0)
                .min().orElseThrow(NoSuchElementException::new);
        System.out.println("Min Claim Amount:==" + minAmount);
    }

    private static void findTheMaxClaim(List<CropInsuranceDTO> cropList) {
        double maxAmount = Optional.ofNullable(cropList)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(Objects::nonNull)
                .mapToDouble(CropInsuranceDTO::getClaimAmountRs)
                .max().orElseThrow(NoSuchElementException::new);
        System.out.println("Max Claim Amount:==" + maxAmount);
    }

    private static List<CropInsuranceDTO> getCropDetails(String fileLocation) {
        List<CropInsuranceDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileLocation))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //listCrop.forEach(c -> System.out.println(c.getMandalName()));
        return listCrop;
    }
}

class VillageAndName {
    private String village;
    private String name;
    private double claim;

    public double getClaim() {
        return claim;
    }

    public void setClaim(double claim) {
        this.claim = claim;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.streams;

import com.oracle.CountriesDemo;
import com.oracle.model.Countries;
import com.oracle.model.RegionAndCode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {
    static List<Integer> regionCodeList = new ArrayList<>();
    static List<String> regionList = new ArrayList<>();
    static List<Countries> countriesList = new ArrayList<>();
    static List<RegionAndCode> regionAndCodeList = new ArrayList<>();

    static List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1", null);

    public static void onLoadData() {
        Stream.of("a1", "a2", "b1", "c2", "c1", null);
        countriesList = CountriesDemo.getCountriesDetails();
        countriesList.add(null);
        Countries countries = new Countries();
        countries.setIntRegionCode(99);
        countries.setRegion(null);

        countriesList.add(countries);

        regionList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Countries::getRegion)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        long regionCount = regionList.stream().filter(f -> f.length() > 4).count();

        regionCodeList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Countries::getRegionCode)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        regionAndCodeList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(StreamsExamples::getRegionAndCode)
                //.filter(Objects::nonNull)
                .filter(f -> {
                    if (f.getRegion() != null && f.getRegionCode() > 0) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());

        System.out.println("regionAndCodeList size is :===" + regionAndCodeList.size());

        Optional.ofNullable(myList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Optional.ofNullable(myList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

    }

    private static RegionAndCode getRegionAndCode(Countries c) {
        RegionAndCode region = new RegionAndCode();
        region.setRegion(c.getRegion());
        region.setRegionCode(c.getRegionCode());
        return region;
    }

    public static void main(String[] args) {
        onLoadData();
        //filterGetSingleColumnList();
        //filterAndSortList();
        //filterList();
        //getDistinctRegions();
        //countriesGroupByDemo();
        //readFileStream();
    }

    private static void readFileStream() {
        System.out.println("====================Space================================");
        try {
            System.out.println("=================inside Try==========");
            Files.lines(Paths.get(ClassLoader.getSystemResource("Topics.txt").toURI())).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("===================Space===================");
        try {
            Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("Topics.txt").toURI()));
            stream
                    .sorted()
                    .filter(f -> f.length() > 63)
                    .forEach(System.out::println);
            stream.close();

            List<String> listText = Files.lines(Paths.get(ClassLoader.getSystemResource("Topics.txt").toURI()))
                    .filter(f -> f.length() > 20)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void countriesGroupByDemo() {

        Map<String, List<Countries>> groupByRegion =
                Optional.ofNullable(countriesList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(c -> c.getRegion() == null ? "NoRegion" : c.getRegion()));
        System.out.println("==============================================================");
        System.out.println("groupByRegion Regions:===" + groupByRegion.size());

        groupByRegion.forEach((k, v) -> {
            System.out.println("Region:=" + k + "===Size:=" + v.size());
        });

        Map<Integer, Countries> map = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Countries::getId, country -> country));
        System.out.println("map Countries:===" + map.size());
    }

    private static void getDistinctRegions() {
        List<String> distinctRegionsList =
                Optional.ofNullable(countriesList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .map(Countries::getRegion)
                        .filter(Objects::nonNull)
                        .map(m -> m.toUpperCase())
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        System.out.println("distinctRegionsList size is :==" + distinctRegionsList.size() + "===distinctRegionsList===" + distinctRegionsList);
    }

    private static void filterList() {
        System.out.println("==============filterList=============");
        countriesList.add(null);
        List<Countries> asiaCountriesList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> {
                    if (null != f.getRegion() && f.getRegion().equalsIgnoreCase("asia")) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        System.out.println("filterList size is ====" + asiaCountriesList.size() + "===asiaCountriesList===" + asiaCountriesList);
    }

    private static void filterAndSortList() {
        System.out.println("==============filterAndSortList=============");
        countriesList.add(null);
        List<String> asiaCountriesList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> {
                    if (null != f.getRegion() && f.getRegion().equalsIgnoreCase("asia")) {
                        return true;
                    }
                    return false;
                })
                .map(Countries::getName)
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("filterAndSortList size is ====" + asiaCountriesList.size() + "===asiaCountriesList===" + asiaCountriesList);
    }

    private static void filterGetSingleColumnList() {
        System.out.println("==============filterGetSingleColumnList=============");
        countriesList.add(null);
        List<String> asiaCountriesList = Optional.ofNullable(countriesList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(f -> {
                    if (null != f.getRegion() && f.getRegion().equalsIgnoreCase("asia")) {
                        return true;
                    }
                    return false;
                })
                .map(Countries::getName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println("filterGetSingleColumnList size is ====" + asiaCountriesList.size() + "===asiaCountriesList===" + asiaCountriesList);
    }
}

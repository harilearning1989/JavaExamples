package com.functional;

import com.oracle.CountriesDemo;
import com.oracle.model.Countries;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForLoopDemo {

    public static void main(String[] args) {
        //difference between filter and map
        //filterAndGetString();
        //filterAndGetDistinctString();

        //filterAndGetCountries();
        //filterAndGetDistinctCountries();
        //filterList();
        inetStreamExamples();
    }

    private static void inetStreamExamples() {
        //IntStream  DoubleStream  LongStream
        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.range(1, 10).skip(5).forEach(System.out::println);
        System.out.println(IntStream.range(1, 10).sum());
    }

    private static void filterList() {

        List<String> cList = new ArrayList<String>();
        cList.add("United States of America");
        cList.add("Ecuador");
        cList.add("Denmark");
        cList.add(null);
        cList.add("Seychelles");
        cList.add("Germany");
        cList.add("Seychelles");
        cList.add("Germany");
        cList.add(null);

        List<String> nonNullResult = cList.stream().filter(Objects::nonNull).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println(nonNullResult + "\n");
        Set<String> nonNullAndUniqResult = new HashSet<>(nonNullResult);
        System.out.println(nonNullAndUniqResult + "\n");

    }

    private static void filterAndGetDistinctString() {
        List<Countries> countries = CountriesDemo.getCountriesDetails();
        countries.add(null);
        Set<String> regionSet = Optional.ofNullable(countries)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull) //filtering car object that are null
                .map(Countries::getIntRegion) //now it's a stream of Strings
                .filter(Objects::nonNull) //filtering null in Strings
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toSet()); //back to List of Strings

        System.out.println("carsFiltered===" + regionSet.size());
    }

    private static void filterAndGetString() {
        List<Countries> countries = CountriesDemo.getCountriesDetails();
        countries.add(null);
        List<String> regionList = Optional.ofNullable(countries)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull) //filtering car object that are null
                .map(Countries::getIntRegion) //now it's a stream of Strings
                .filter(Objects::nonNull) //filtering null in Strings
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList()); //back to List of Strings

        System.out.println("carsFiltered===" + regionList.size());
    }

    public static void filterAndGetCountries() {
        List<Countries> countries = CountriesDemo.getCountriesDetails();
        List<Countries> countriesList = countries.stream()
                .filter(contre ->
                        Optional.ofNullable(contre)
                                .map(Countries::getIntRegion)
                                .filter(Objects::nonNull)
                                .map(name -> name.startsWith("C"))
                                .orElse(false) // what to do if either car or getName() yields null? false will filter out the element
                )
                .collect(Collectors.toList());
        System.out.println("countries size===" + countries.size() + "===countriesList size===" + countriesList.size());

    }

    public static void filterAndGetDistinctCountries() {
        List<Countries> countries = CountriesDemo.getCountriesDetails();
        Set<Countries> countriesSet = countries.stream()
                .filter(contre ->
                        Optional.ofNullable(contre)
                                .map(Countries::getIntRegion)
                                .filter(Objects::nonNull)
                                .map(name -> name.startsWith("C"))
                                .orElse(false) // what to do if either car or getName() yields null? false will filter out the element
                )
                .collect(Collectors.toSet());
        System.out.println("countries size===" + countries.size() + "===countriesList size===" + countriesSet.size());

    }
}

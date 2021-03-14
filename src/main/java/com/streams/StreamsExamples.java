package com.streams;

import com.github.ReadCSVFiles;
import com.github.dto.CropInsuranceDTO;
import com.oracle.CountriesDemo;
import com.oracle.model.Countries;
import com.oracle.model.RegionAndCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;

public class StreamsExamples {

    /*allMatch  anyMatch  noneMatch collect  concat  distinct()  empty  filter  findAny  findFirst
    flatMap  flatMapToDouble  flatMapToInt  flatMapToLong  forEach  forEachOrdered
    generate  iterate  limit  map  mapToDouble  mapToInt  mapToLong  max  min  of  peek  reduce
    skip sum sorted toArray*/

    static List<Integer> regionCodeList = new ArrayList<>();
    static List<String> regionList = new ArrayList<>();
    static List<Countries> countriesList = new ArrayList<>();
    static List<RegionAndCode> regionAndCodeList = new ArrayList<>();

    static List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1", null);

    public static void main(String[] args) {
        //onLoadData();
        //filterGetSingleColumnList();
        //filterAndSortList();
        //filterList();
        //getDistinctRegions();
        //countriesGroupByDemo();
        //readFileStream();
        //List<CropInsuranceDTO> cropDetails = ReadCSVFiles.readCropDetails("csv/crop_insurance.csv");
        //mapFunctions(cropDetails);

        //List<CountryModel> list = getCountriesData();
        //System.out.println(list.size());
        //streamsExamples();
        //streamsBasics();
        //comparatorExamples();
        //streamExamples();
        //sortWithoutStream();
        //collectorsExamples();
        try {
            optionalExamples();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Set<Integer> result = findDuplicateBySetAdd(list);
        result.forEach(System.out::println);
    }

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

    private static void groupByFunctions(List<CropInsuranceDTO> cropDetails) {
        Map<String, List<CropInsuranceDTO>> basedOnMandal = Optional.ofNullable(cropDetails)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(CropInsuranceDTO::getMandalName));
    }

    private static void mapFunctions(List<CropInsuranceDTO> cropDetails) {
        List<Double> doubleList = Optional.ofNullable(cropDetails)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(CropInsuranceDTO::getClaimAmountRs)
                .distinct()
                .collect(Collectors.toList());
        CropInsuranceDTO dto = new CropInsuranceDTO();
        dto.setBankName("SBI");
        dto.setVillageName(null);
        cropDetails.add(dto);
        List<String> distVillages = Optional.ofNullable(cropDetails)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(CropInsuranceDTO::getVillageName)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distVillages.size());
    }

    public static void aggregateFunctions(List<CropInsuranceDTO> cropDetails) {
        Optional<CropInsuranceDTO> maxClaimAmount =
                Optional.ofNullable(cropDetails)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.maxBy(Comparator.comparing(CropInsuranceDTO::getClaimAmountRs)));
        System.out.println("Maximum Claim Amount:" + (maxClaimAmount.isPresent() ?
                maxClaimAmount.get().getClaimAmountRs() : "Not Applicable"));
        Optional<CropInsuranceDTO> minClaimAmount =
                Optional.ofNullable(cropDetails)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.minBy(Comparator.comparing(CropInsuranceDTO::getClaimAmountRs)));
        System.out.println("Minimum Claim Amount:" + (minClaimAmount.isPresent() ?
                minClaimAmount.get().getClaimAmountRs() : "Not Applicable"));

    }

    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
       /* return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());*/

        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(i -> Collections.frequency(list, i) == 1)
                .collect(Collectors.toSet());
    }

    public static void optionalExamples() throws ClassNotFoundException, SQLException {

       /* empty()  equals(Object obj)  filter  flatMap  get()  ifPresent  isPresent()
        map of  ofNullable  orElse  orElseGet  orElseThrow  toString()*/

        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        list.add(m);

        CountryModel p = new CountryModel();
        Optional<CountryModel> op = Optional.of(p);

    }

    public static void streamExamples() throws ClassNotFoundException, SQLException {
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        list.add(m);
    }

    public static void collectorsExamples() throws ClassNotFoundException, SQLException {
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        list.add(m);
        //summingInt  groupingBy  joining  counting()  averagingInt  mapping maxBy  minBy
        int countId = list.stream()
                .collect(Collectors.summingInt(CountryModel::getCountryId));

        /*String chString = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));*/

        //System.out.println("countId==="+countId);
        List<String> wordsList = Arrays.asList("d", "w", "f", "a", "s", "c", "f");
        Map<String, Long> mapCount =
                wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> collect =
                wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        Map<String, Integer> totalByDept
                = list.stream().filter(x -> x.getRegion() != null)
                .collect(Collectors.groupingBy(CountryModel::getRegion,
                        Collectors.summingInt(CountryModel::getCountryId)));
        Optional<CountryModel> maxId =
                list.stream()
                        .collect(Collectors.maxBy(Comparator.comparing(CountryModel::getCountryId)));
        Stream<String> stream = Stream.of("4", "7", "25", "87", "4");
        Optional<String> op = stream.collect(Collectors.maxBy(String::compareTo));
        System.out.println(op.get());
        //collect.forEach((k,v) -> System.out.println(k+"==="+v));
    }

    public static void sortWithoutStream() throws ClassNotFoundException, SQLException {
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        m.setSubRegion("aaaa");
        list.add(m);
        List<String> listLet = Arrays.asList("d", "f", "w", "a", "A", "d", "c", null);
        listLet.sort(Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
        //listLet.forEach(x -> System.out.println(x));
        //list.sort(comparing(CountryModel::getSubRegion,nullsLast(naturalOrder())));//No Case
        //list.sort(comparing(CountryModel::getSubRegion,nullsLast(String.CASE_INSENSITIVE_ORDER)));  //No Multi
        list.sort(comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))
                .thenComparing(CountryModel::getCountryName, nullsLast(String.CASE_INSENSITIVE_ORDER).reversed()));
        list.forEach(l -> System.out.println(l.getSubRegion() + "==" + l.getCountryName()));
    }

    public static void comparatorExamples() throws ClassNotFoundException, SQLException {
       /*
       compare  comparing comparingDouble comparingInt  comparingLong  equals  naturalOrder  thenComparingLong
        nullsFirst  nullsLast  reversed  reverseOrder  thenComparing  thenComparingDouble  thenComparingInt
        */
        List<String> listAlpha = Arrays.asList("b", "q", null, "s", "h", "d", "r");
        List<String> sortedFruit = listAlpha.stream()
                .sorted(nullsLast(String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        m.setSubRegion("aaaa");
        list.add(m);
        //list.stream().forEach(l -> System.out.println(l.getSubRegion()));
        //List<CountryModel> list1 = list.stream().sorted(comparing(CountryModel::getSubRegion,nullsLast(naturalOrder()))).collect(Collectors.toList());//no case
       /* List<CountryModel> list1 = list.stream()
                .sorted(comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .collect(Collectors.toList());*/  //no reverse
        /*List<CountryModel> list1 = list.stream()
                .sorted(comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER).reversed()))
                .collect(Collectors.toList());*/   //  No Multi
       /* List<CountryModel> list1 = list.stream()
                .sorted(
                        comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))
                .thenComparing(CountryModel::getCountryName, nullsLast(String.CASE_INSENSITIVE_ORDER).reversed()))
                .collect(Collectors.toList());*/   //No thenComparingInt
        List<CountryModel> list1 = list.stream()
                .sorted(
                        comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))
                                .thenComparing(CountryModel::getRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))
                                .thenComparingInt(CountryModel::getCountryId))
                .collect(Collectors.toList());
        list1.stream().forEach(l -> System.out.println(l.getSubRegion() + "==getRegion====" + l.getRegion() + "===Country Id===" + l.getCountryId()));
    }

    public static void streamsExamples() throws ClassNotFoundException, SQLException {
        List<CountryModel> list = getCountriesData();
        //list.stream().filter(c -> c.getCountryId() > 100).forEach(x -> System.out.println("print the country id=="+x.getCountryId()));
        List<CountryModel> listfilter = list.stream().filter(c -> c.getCountryId() > 200).collect(Collectors.toList());
        //System.out.println(listfilter.size());

        Map<String, Long> counting = list
                .stream()
                .filter(p -> p.getRegion() != null)
                .collect(Collectors.groupingBy(CountryModel::getRegion, Collectors.counting()));
        System.out.println(counting);
       /* Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));*/
    }

    public static void streamsBasics() throws ClassNotFoundException, SQLException {
       /* Stream<Integer> intStream = Stream.of(1,2,3,4);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println("intList====="+intList); //prints [1, 2, 3, 4]

        intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
        Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
        System.out.println("intMap====="+intMap); //prints {1=11, 2=12, 3=13, 4=14}*/
        /*Stream<String> stream = Stream.of("g", "e", "a", "d", "A", "B");
        stream.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);*/
        List<CountryModel> list = getCountriesData();
        //list.stream().forEach(l -> System.out.println(l.getSubRegion()));
        List<CountryModel> list1 = list.stream().sorted(comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))).collect(Collectors.toList());
        list1.forEach(l -> System.out.println(l.getSubRegion()));
    }

    public static List<CountryModel> getCountriesData() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle_main", "manager");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select COUNTRY_ID,COUNTRY_NAME,ALPHA2,ALPHA3,COUNTRY_CODE,REGION,SUB_REGION,INTERMEDIATE_REGION,REGION_CODE,SUB_REGION_CODE" +
                ",INTERMEDIATE_REGION_CODE from COUNTRY_REGIONS");
        List<CountryModel> listCountry = new ArrayList<>();
        CountryModel c = null;

        while (rs.next()) {
            c = new CountryModel();
            // System.out.println(rs.getInt("COUNTRY_ID") + "  " + rs.getString("COUNTRY_NAME") + "  " + rs.getString("ALPHA2"));
            c.setCountryId(rs.getInt("COUNTRY_ID"));
            c.setCountryName(rs.getString("COUNTRY_NAME"));
            c.setAlpha2(rs.getString("ALPHA2"));
            c.setAlpha3(rs.getString("ALPHA3"));
            c.setCountryCode(rs.getString("COUNTRY_CODE"));
            c.setRegion(rs.getString("REGION"));
            c.setSubRegion(rs.getString("SUB_REGION"));
            c.setInterRegion(rs.getString("INTERMEDIATE_REGION"));
            c.setRegionCode(rs.getString("REGION_CODE"));
            c.setSubRegionCode(rs.getString("SUB_REGION_CODE"));
            c.setInterRegionCode(rs.getString("INTERMEDIATE_REGION_CODE"));

            listCountry.add(c);
        }

        con.close();
        return listCountry;
    }
}

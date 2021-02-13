package com.streams;

import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;

public class StreamPracticed {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //List<CountryModel> list = getCountriesData();
        //System.out.println(list.size());
        //streamsExamples();
        //streamsBasics();
        //comparatorExamples();
        //streamExamples();
        //sortWithoutStream();
        //collectorsExamples();
        optionalExamples();
    }

    public static void optionalExamples()throws ClassNotFoundException,SQLException{

       /* empty()  equals(Object obj)  filter  flatMap  get()  ifPresent  isPresent()
        map of  ofNullable  orElse  orElseGet  orElseThrow  toString()*/

        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();  list.add(m);

        CountryModel p = new CountryModel();
        Optional<CountryModel> op = Optional.of(p);

    }

    public static void streamExamples()throws ClassNotFoundException,SQLException{
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();  list.add(m);
    }
    public static void collectorsExamples()throws ClassNotFoundException,SQLException{
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();  list.add(m);
        //summingInt  groupingBy  joining  counting()  averagingInt  mapping maxBy  minBy
        int countId = list.stream()
                .collect(Collectors.summingInt(CountryModel::getCountryId));

        /*String chString = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));*/

        //System.out.println("countId==="+countId);
        List <String> wordsList = Arrays.asList("d", "w", "f", "a", "s","c","f");
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
        Stream<String> stream = Stream.of("4", "7", "25", "87","4");
        Optional<String> op = stream.collect(Collectors.maxBy(String::compareTo));
        System.out.println(op.get());
        //collect.forEach((k,v) -> System.out.println(k+"==="+v));
    }
    public static void sortWithoutStream()throws ClassNotFoundException,SQLException{
        List<CountryModel> list = getCountriesData();
        CountryModel m = new CountryModel();
        m.setSubRegion("aaaa");
        list.add(m);
        List<String> listLet = Arrays.asList("d","f","w","a","A","d","c",null);
        listLet.sort(Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
        //listLet.forEach(x -> System.out.println(x));
        //list.sort(comparing(CountryModel::getSubRegion,nullsLast(naturalOrder())));//No Case
        //list.sort(comparing(CountryModel::getSubRegion,nullsLast(String.CASE_INSENSITIVE_ORDER)));  //No Multi
        list.sort(comparing(CountryModel::getSubRegion, nullsLast(String.CASE_INSENSITIVE_ORDER))
                                .thenComparing(CountryModel::getCountryName, nullsLast(String.CASE_INSENSITIVE_ORDER).reversed()));
        list.forEach(l -> System.out.println(l.getSubRegion()+"=="+l.getCountryName()));
    }
    public static void comparatorExamples() throws ClassNotFoundException,SQLException{
       /*
       compare  comparing comparingDouble comparingInt  comparingLong  equals  naturalOrder  thenComparingLong
        nullsFirst  nullsLast  reversed  reverseOrder  thenComparing  thenComparingDouble  thenComparingInt
        */
        List<String> listAlpha = Arrays.asList("b", "q",null, "s","h","d","r");
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
        list1.stream().forEach(l -> System.out.println(l.getSubRegion()+"==getRegion===="+l.getRegion()+"===Country Id==="+l.getCountryId()));
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

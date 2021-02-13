package com.practice.lambda;

import com.models.Developer;
import com.models.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class LambdaExpressions {


    public static void nullsFirstSorting() {
        //final Comparator<Person> comparator = comparing(Person::getName, nullsFirst(naturalOrder()));
        final Comparator<Person> comparator =
                comparing(Person::getName, nullsFirst(reverseOrder()))
                        .thenComparing(Person::getId,reverseOrder());
        final List<Person> persons = Arrays.asList(
                new Person(1, "Cristian"),
                new Person(2, "Guadalupe"),
                new Person(3, "Cristina"),
                new Person(2, "Cristina"),
                new Person(1, "Cristina"),
                new Person(4, "Chinga"),
                new Person(5, null));
        persons
                .stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void sortUsingComparator(){
        List<Developer> listDevs = getDevelopers();
        //listDevs.sort((Developer o1, Developer o2)->o2.getAge()-o1.getAge());
        listDevs.sort((Developer o1, Developer o2)->o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
        listDevs.forEach(d->System.out.println(d.getName()));

        String[] myArray = {"JavaFX", null, "OpenCV", null, "Hadoop", null};
        Arrays.sort(myArray,Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Arrays.toString(myArray));
    }

    public static void main(String[] args) {
        //nullsFirstSorting();
        sortUsingComparator();
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));
        result.add(new Developer("Alvin", new BigDecimal("82000"), 22));
        result.add(new Developer("Mkyong", new BigDecimal("700"), 31));
        //result.add(new Developer(null, new BigDecimal("700"), 31));

        return result;

    }
}

package com.functional.prct;

import com.oracle.CountriesDemo;
import com.oracle.model.Countries;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

    /*Predicate
     *BiPredicate  DoublePredicate  IntPredicate  LongPredicate
     * */
    /*Methods
    test  and  or  negate  isEqual*/
    public static void main(String[] args) {
        //getCountries();
        testMethodDemo();

    }

    private static void testMethodDemo() {

        Predicate<String> lengthPrdt = p -> p.length() > 0;
        String str = null;
        Optional<String> check = Optional.ofNullable(str);
        if (check.isPresent()) {
            System.out.println(lengthPrdt.test(check.get()));
        }
        DoublePredicate db = (x) -> {
            return x * x <= 100.0;
        };
        System.out.println("100 is less than 100 " + db.test(10));
        IntPredicate intPrdt = i -> i * i > 20;
        System.out.println("100 is less than 20 " + intPrdt.test(10));
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean resultAnd = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println("resultAnd is:=" + resultAnd);

        boolean resultNegate = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println("resultNegate is:=" + resultNegate);
        boolean resultOr = greaterThanTen.or(lowerThanTwenty).test(15);
        System.out.println("resultOr is:=" + resultOr);
    }

    private static void getCountries() {

    }
}

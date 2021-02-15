package com.functional.suppl;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

    /*  BooleanSupplier
     *   DoubleSupplier  IntSupplier  LongSupplier
     * */
    /*IntSupplier int getAsInt();
    DoubleSupplier double getAsDouble();
    LongSupplier long getAsLong();
    BooleanSupplier boolean getAsBoolean();*/

    //get  getAsBoolean  getAsDouble  getAsInt  getAsLong
    public static void main(String[] args) {

        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;
        Supplier<Double> doubleSupplier3 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
        System.out.println(doubleSupplier3.get());

    }
}

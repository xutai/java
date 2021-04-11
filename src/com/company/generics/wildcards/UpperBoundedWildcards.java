package com.company.generics.wildcards;

import java.util.Arrays;
import java.util.List;

/* Upper Bounded Wildcards */

public class UpperBoundedWildcards {
    /* list number/integer example */
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void calc() {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum= " + sumOfList(ld));
    }

    public static void main(String[] args) {
        calc();
        operate();
    }

    /* foo bar example */
    static class Foo {
    }

    static class Bar extends Foo {
    }

    public static void process(List<? extends Foo> list) {
        for (Foo elem : list) {

        }
    }

    public static void operate() {
        List<Foo> fooList = Arrays.asList(new Foo(), new Foo());
        List<Foo> barList = Arrays.asList(new Bar(), new Bar());
        process(fooList);
        process(barList);
    }


}

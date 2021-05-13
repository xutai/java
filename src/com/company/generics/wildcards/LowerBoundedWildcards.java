package com.company.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Object -> Number -> Integer
* supertypes -> subtypes
* */

public class LowerBoundedWildcards {
    public static void main(String[] args) {
//        listHandler_exception();
        listHandler();
    }

    static void listHandler_exception() {
        /* exception, asList is a fixed sized, cannot use add to dynamically add */
        List<Integer> list = Arrays.asList(1, 2, 3);
        addNumbers(list);
    }

    static void listHandler() {
        List<Integer> list = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        addNumbers(list);
        addNumbers(list2);
        addNumbers(list3);
        for (int E : list) {
            System.out.printf("%s", E);
        }
    }
    static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
    }



}

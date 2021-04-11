package com.company.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcards {
    static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i <= 10; i++) {
            list.add(i);
//            list.add(1.1);
        }
    }

    static void listHandler() {
        /* exception, asList is a fixed sized, cannot use add to dynamically add */
//        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list = new ArrayList<>();
//        List<Number> list2 = new ArrayList<>();
//        List<Object> list3 = new ArrayList<>();
        addNumbers(list);
//        addNumbers(list2);
//        addNumbers(list3);
        for (int i : list) {
            System.out.printf("%s", i);
        }
    }

    public static void main(String[] args) {
        listHandler();
    }
}

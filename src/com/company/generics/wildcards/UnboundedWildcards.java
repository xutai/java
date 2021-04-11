package com.company.generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {
    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void printList2(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void handleList() {
        List<Object> list1 = Arrays.asList(new Object(), new String());
        List<String> list2 = Arrays.asList(new String(), new String());
        List<String> list4 = Arrays.asList(new String(), new String());
        List<?> list6 = Arrays.asList(new Object(), new String());
        List<?> list7 = Arrays.asList(null, null);
        List<?> list5 = Arrays.asList(new Object(), new String());
        List<?> list8 = Arrays.asList(null, null);
        printList(list1);
//        printList(list2);
//        printList(list6);
//        printList(list7);
        printList2(list1);
        printList2(list4);
        printList2(list5);
        printList2(list8);

    }

    public static void main(String[] args) {
        handleList();
    }
}

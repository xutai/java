package com.company.collections.interfaces;


import java.util.*;
import java.util.stream.Collectors;

/*
 * set env:
 * export CLASSPATH=D:\\github\\java\\out\\production\\java
 * echo $CLASSPATH
 *
 * run:
 * java InterfaceSet if it is to be it is up to me to delegate
 * java com.company.collections.interfaces.InterfaceSet if it is to be it is up to me to delegate
 * */

public class InterfaceSet {
    public static void main(String[] args) {
        try {
            FindDups.main(args);
            FindDups2.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}



class FindDups {
    public static void main(String[] args) {
        usingJDK8AggregateOperatons(args);
        usingTheForEachConstruct(args);
    }
    private static void usingJDK8AggregateOperatons(String[] args) {
        Set<String> distinctWords = Arrays.asList(args).stream()
                .collect(Collectors.toSet());
        System.out.println(distinctWords.size()+ " distinct words: " + distinctWords);
    }
    private static void usingTheForEachConstruct(String[] args) {
//        Set<String> s = new HashSet<String>();
        Set<String> s = new TreeSet<String>();
        for (String a : args) {
            s.add(a);
        }
        System.out.println(s.size() + " distinct words: " + s);
    }

}

class FindDups2 {
    public static void main(String[] args) {
        Set<String> uniques = new HashSet<String>();
        Set<String> dups = new HashSet<String>();

        for (String a : args) {
            if (!uniques.add(a)) {
                dups.add(a);
            }
        }

        // Destructive set-difference
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}
package com.company.collections.interfaces;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


/*
 * set env:
 * export CLASSPATH=D:\\java\\out\\production\\java
 * echo $CLASSPATH
 *
 * run:
 * java InterfaceMap if it is to be it is up to me to delegate
 * java com.company.collections.interfaces.InterfaceMap if it is to be it is up to me to delegate
 * */

public class InterfaceMap {
    public static void main(String[] args) {
        try {
            Freq.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


class Freq {
    public static void main(String[] args) throws Exception {
//        useHashMap(args);
//        useTreeMap(args);
        useCopy(args);
    }

    /*
    * Map Interface Basic Operations
    * */
    public static void useHashMap(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();


        // Initialize frequency table from command line
        duplicateCode(args, m);
    }

    public static void useTreeMap(String[] args) {
        Map<String, Integer> m = new TreeMap<String, Integer>();

        // Initialize frequency table from command line
        duplicateCode(args, m);
    }

    private static void duplicateCode(String[] args, Map<String, Integer> m) {
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }

    public static void useCopy(String[] args) {
        Map<String, Integer> copyFrom = new HashMap<String, Integer>();
        duplicateCode(args, copyFrom);
        Map<String, Integer> copyTo = new HashMap<String, Integer>(copyFrom);
        System.out.println(copyTo);
    }

    /*
    * Map Interface Bulk Operations
    * */
    static <K, V> Map<K, V> newAttributeMap(Map<K, V>defaults, Map<K, V> overrides) {
        Map<K, V> result = new HashMap<K, V>(defaults);
        result.putAll(overrides);
        return result;
    }
}
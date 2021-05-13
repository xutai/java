package com.company.classes.LambdaExpressions;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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

public class MethodReferences {
    public static void main(String[] args) {
        try {
//            com.company.classes.LambdaExpressions.Person.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


/*
* The method reference Person::compareByAge
* is semantically the same as
* the lambda expression (a, b) -> Person.compareByAge(a, b).
* */

class ABC {
    public static void main(String[] args) throws Exception {
//        useHashMap(args);
//        useTreeMap(args);
//        useCopy(args);
    }

}
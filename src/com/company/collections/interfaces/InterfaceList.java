package com.company.collections.interfaces;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * set env:
 * export CLASSPATH=D:\\github\\java\\out\\production\\java
 * echo $CLASSPATH
 *
 * run:
 * java InterfaceSet if it is to be it is up to me to delegate
 * java com.company.collections.interfaces.InterfaceSet if it is to be it is up to me to delegate
 * */
public class InterfaceList {
    public static void main(String[] args) {
        try {
//            Shuffle.main(args);



            /* method 1 */
//            String [] args2;
//            args2 = new String[10];
//            args2[0] = "123";
//            args2[1] = "456";

            /* method 2 */
            String [] args2 = {
                "123", "456"
            };



            Shuffle.main(args2);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


class Shuffle {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        Collections.shuffle(list);
        System.out.println(list);
    }
}

class CollectionOperations{
    public static void main(String[] args) {
        usingJDK8AggregateOperatons(args);
    }
    private static void usingJDK8AggregateOperatons(String[] args) {

    }


}

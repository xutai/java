package com.company.generics;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String... args) {
        List list = new ArrayList();
        list.add("hi");
        String s = (String) list.get(0);

        List<String> list2 = new ArrayList<String>();
        list2.add("world");
        String s2 = list2.get(0);
    }
}

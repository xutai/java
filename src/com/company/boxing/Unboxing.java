package com.company.boxing;

import java.util.ArrayList;
import java.util.List;

class Boxing {
    public static int sumEven(List<Integer> li) {
        int sum = 0;
//        for (Integer i: li)
//            if (i % 2 == 0)
//                sum += i;
        for (Integer i : li)
            if (i.intValue() % 2 == 0)
                sum += i.intValue();
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2) {
            li.add(i);
            li.add(Integer.valueOf(i));
        }
        System.out.println(li);
        int sum = sumEven(li);
        System.out.println(sum);

    }
}

public class Unboxing {

    public static void main(String[] args) {
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // Π is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}
package com.company.generics.TypeErasure;

public class ErasureOfGenericMethods {
    // Counts the number of occurrences of elem in anArray.
//
    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }
}

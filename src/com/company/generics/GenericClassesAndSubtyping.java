package com.company.generics;

import java.util.List;

public class GenericClassesAndSubtyping {
    interface PayloadList<E,P> extends List<E> {
        void setPayload(int index, P val);
    }
    public abstract class PayloadListClass implements PayloadList<String,String> {
        public void setPayload(int index, String val) {
//            System.out.printf("%s", "123");
        }
    }
    public abstract class PayloadListClassInteger implements PayloadList<String,Integer> {}
    public abstract class PayloadListClassException implements PayloadList<String,Exception> {}
    public static void main(String[] args) {
        GenericClassesAndSubtyping gcs = new GenericClassesAndSubtyping();
//        gcs
    }
}

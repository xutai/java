package com.company.generics;

import java.util.*;

/* Type Inference */
public class TypeInference {
    /* Type Inference and Generic Methods */
    public class BoxDemo {
    }

    static class Box<U> {
        U u;

        void Box() {
        }

        void set(U u) {
            this.u = u;
        }

        U get() {
            return this.u;
        }
    }

    public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            ;
            counter++;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
        TypeInference.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        TypeInference.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        TypeInference.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        TypeInference.outputBoxes(listOfIntegerBoxes);
        instantiation();
        createMyClass();
    }

    /* Type Inference and Instantiation of Generic Classes */
    static void instantiation() {
        Map<String, List<String>> myMap = new HashMap<String, List<String>>();
        Map<String, List<String>> myUncheckedConversionMap = new HashMap();
    }

    /* Type Inference and Generic Constructors of Generic and Non-Generic Classes */
    static class MyClass<X> {
        <T> MyClass(T t) {
            // ...
        }
    }

    static void createMyClass() {
        new MyClass<Integer>("");
        MyClass<Integer> myObject = new MyClass<>("");
    }

    /* Target Types
     * static <T> List<T> emptyList();
     * */
    static void targetTypes() {
        List<String> listOne = Collections.emptyList();
        List<String> listTwo = Collections.<String>emptyList();
        processStringList(Collections.emptyList());
        processStringList(Collections.<String>emptyList());
    }

    static void processStringList(List<String> stringList) {
    }

}

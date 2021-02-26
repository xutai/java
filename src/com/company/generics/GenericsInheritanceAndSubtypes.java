package com.company.generics;

public class GenericsInheritanceAndSubtypes {
    public void someMethod(Number n) { /* */ }
    public class Box<T> {
        public Box() {}
        public void add(T t) {}
    }
    public void boxTest(Box<Number> n) {}
    public static void main(String[] args) {
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        /*
        * "is a" relationship
        * an Integer is a kind of Object */
        someObject = someInteger;

        GenericsInheritanceAndSubtypes gis = new GenericsInheritanceAndSubtypes();
        gis.someMethod(new Integer(10));
        gis.someMethod(new Double(10.1));

        Box<Number> box = gis.new Box<Number>();
        box.add(new Integer(10));
        box.add(new Double(10.1));

        gis.boxTest(box);
//        gis.boxTest(gis.new Box<Integer>());
//        gis.boxTest(gis.new Box<Double>());
    }
}

package com.company.collections.interfaces;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.Color;

/*
 * set env:
 * export CLASSPATH=D:\\github\\java\\out\\production\\java
 * echo $CLASSPATH
 *
 * run:
 * java InterfaceSet if it is to be it is up to me to delegate
 * java com.company.collections.interfaces.InterfaceSet if it is to be it is up to me to delegate
 * */
public class InterfaceCollection {
    public static void main(String[] args) {
        try {
            CollectionOperationsArrayList.main(args);
            BasicOperations.main(args);
            OperateOnEntireCollections.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class BasicOperations {
    public static void main(String[] args) {
        List<String> list = generateList.getList();
        int size = list.size();
        boolean isEmpty = list.isEmpty();
        boolean isContains = list.contains("123");
        boolean addElement = list.add("789");
        boolean removeObject = list.remove("456");
        Iterator<String> iterator = list.iterator();
    }
}

class OperateOnEntireCollections {
    public static void main(String[] args) {
        List<String> list1 = generateList.getList();
        List<String> list2 = generateList.getList2();
        boolean containsAll = list1.containsAll(list2);
        boolean addAll = list1.addAll(list2);
        boolean removeAll = list1.removeAll(list2);
        boolean retainAll = list1.retainAll(list2);
        list1.clear();
    }
}

class ArrayOperations {
    public static void main(String[] args) {
        List<String> list = generateList.getList();
        Object[] arrayOfObjects = list.toArray();
    }
}

class generateArray {
//    public static <E> E[] getArray(int size) {
//        E[] arr = new E[size];
//        return arr;
//    };

    public static <E> E[] getArray(Class<E> clazz, int size) {
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) Array.newInstance(clazz, size);
        return arr;
    };

}

class SequentialOrParallelStreams {
    public static void main(String[] args) {
        List<String> list = generateList.getList();
        Stream<String> stream = list.stream();
        Stream<String> parallelSteam = list.parallelStream();
    }
}

class generateList {
    public static void main(String[] args) {}
    public static List<String> getList() {
        String [] args2 = {
                "123", "456"
        };
        /*
         * Collection<String> c, which may be a List, a Set, or another kind of Collection
         * */
        List<String> c = Arrays.asList(args2);
        List<String> list = new ArrayList<String>(c);
        /*
         * if you are using JDK 7 or later — you can use the diamond operator:
         * */
//        List<String> list = new ArrayList<>(c);
        return list;
    }
    public static List<String> getList2() {
        String[] args3 = {
                "123", "abc"
        };
        List<String> list2 = Arrays.asList(args3);
        return list2;
    }
}

class CollectionOperationsArrayList{
    public static void main(String[] args) {
//        TraversingCollectionsAggregateOperations.AggregateOperations(args);
//        TraversingCollectionsAggregateOperations.AggregateOperationsParallel(args);
        TraversingCollectionsAggregateOperations.collectData(args);
    }

    static class Shape {
        final Color color;
        public Shape(Color newColor)  { color = newColor; }
        Color getColor() { return color; }
        String getName() {  return getClass().getName(); }
    }

    static class TraversingCollectionsAggregateOperations {
         private static void AggregateOperations(String[] args) {
             //             myShapesCollection.stream()
//                     .filter(e -> e.getColor() == Color.RED)
//                     .forEach(e -> System.out.println(e.getName()));
             List<Shape> myShapesCollection = new ArrayList<>();
             Shape shape_red = new Shape(Color.RED);
             Shape shape_green = new Shape(Color.GREEN);
             myShapesCollection.add(0, shape_red);
             myShapesCollection.add(1, shape_green);
             Stream<Shape> stream1;
             Stream<Shape> stream2;
             stream1 = myShapesCollection.stream();
             Predicate<Shape> predicate1;
             Predicate<Shape> predicate2;
             predicate1 = e -> e.getColor() == Color.RED;
             predicate2 = e -> e.getColor() == Color.GREEN;
             Boolean test1 = predicate1.test(shape_green);
             Predicate<? super Shape> negate1 = predicate1.negate();
             Boolean test2 = negate1.test(shape_green);
             Predicate<Shape> and1 = predicate1.and(predicate2);
             Boolean test3 = and1.test(shape_green);
             Predicate<Shape> or1 = predicate1.or(predicate2);
             Boolean test4 = or1.test(shape_green);
             Predicate<Shape> isEqual = Predicate.isEqual(predicate1);
             Boolean isEqualBoolean = isEqual.equals(predicate2);
             Predicate<Shape> not = Predicate.not(predicate1);
             Boolean test5 = not.test(shape_green);
             Consumer<Shape> consumer;
             consumer = e -> System.out.println(e.getName());
             stream2 = stream1.filter(predicate1);
             stream2.forEach(consumer);



         }
        private static void AggregateOperationsParallel(String[] args) {
            List<Shape> myShapesCollection = new ArrayList<>();
            Shape shape_red = new Shape(Color.RED);
            Shape shape_green = new Shape(Color.GREEN);
            myShapesCollection.add(0, shape_red);
            myShapesCollection.add(1, shape_green);
            Stream<Shape> parallelStream = myShapesCollection.parallelStream();
            myShapesCollection.parallelStream()
                    .filter(e -> e.getColor() == Color.RED)
                    .forEach(e -> System.out.println(e.getName()));
        }
        private static void collectData(String[] args) {
//            String joined = elements.stream()
//                    .map(Object::toString)
//                    .collect(Collectors.joining(", "));

            List<Shape> elements = new ArrayList<>();
            Shape shape_red = new Shape(Color.RED);
            Shape shape_green = new Shape(Color.GREEN);
            elements.add(0, shape_red);
            elements.add(1, shape_green);

            Stream<Shape> stream1;
            Stream<String> stream2;
            stream1 = elements.stream();
            Function<Shape, String> function = Object::toString;
//            Function<Shape, String> function = e -> e.toString();
            stream2 = stream1.map(function);
            Collector<CharSequence, ?, String> collector = Collectors.joining(", ");
            Supplier<?> supplier = collector.supplier();
            BiConsumer<?, CharSequence> biconsumer = collector.accumulator();
            BinaryOperator<?> binaryOperator = collector.combiner();
            Function<?, String> finisher = collector.finisher();
            Set<Characteristics> characteristics = collector.characteristics();
            String joined = stream2.collect(collector);

        }
        private static void sum(String[] args) {
//            int total = employees.stream()
//                    .collect(Collectors.summingInt(Employee::getSalary)));
        }

    }

    class TraversingCollectionsForEachConstruct {
//        private static void AggregateOperations(String[] args) {
//            for (Object o : collection)
//                System.out.println(o);
//        }

    }


    class TraversingCollectionsIterators {
        private static void AggregateOperations(String[] args) {}
    }


}



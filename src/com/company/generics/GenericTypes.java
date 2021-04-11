package com.company.generics;


/*
 * Generic Types
 *   A Simple Box Class
 *   A Generic Version of the Box Class
 *       non-primitive type
 *   Type Parameter Naming Conventions
 *   Invoking and Instantiating a Generic Type
 *       parameterized type
 *   The Diamond
 *       type inference
 *   Multiple Type Parameters
 *       autoboxing
 *   Parameterized Types
 * */

/* v1 */
//interface Pair {
//    public String getKey();
//    public String getValue();
//}
//
//public class OrderedPair implements Pair {
//    public String getKey() {
//        return "";
//    }
//    public String getValue() {
//        return "";
//    }
//
//    public static void main(String... args) {}
//}

/* v2 */
/*interface Pair {
    public String getKey();
    public String getValue();
}

public class OrderedPair implements Pair {
    String key;
    String value;
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    public static void main(String... args) {}
}*/

import java.security.Key;

/* v3 */
//interface Pair {
//    public String getKey();
//    public String getValue();
//}
//
//public class OrderedPair implements Pair {
//    String key;
//    String value;
//    OrderedPair(String k, String v) {
//        key = k;
//        value = v;
//    }
//    public String getKey() {
//        return key;
//    }
//    public String getValue() {
//        return value;
//    }
//
//    public static void main(String... args) {
//        System.out.println(new OrderedPair("key", "value").getKey());
//    }
//}

/* v4 */
/*interface Pair {
    public String getKey();
    public String getValue();
}*/
/* incorrect */
/*public class OrderedPair implements Pair {
    String key;
    String value;
    *//* Variable 'key' is already defined in the scope *//*
    OrderedPair(String key, String key) {
        key = key;
        value = key;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    public static void main(String... args) {
        System.out.println(new OrderedPair("key", "value").getKey());
    }
}*/

/* v5 */
/*
interface Pair<K, V> {
    public K getKey();
    public V getValue();
}


public class OrderedPair<K, V> implements Pair<K, V> {
    K key;
    V value;
    OrderedPair(K k, V v) {
        key = k;
        value = v;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

    public static void main(String... args) {
        System.out.println(new OrderedPair("key", "value").getKey());
    }
}*/

/* v6 */
class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    ;

    public void setValue(V value) {
        this.value = value;
    }

    ;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

class OrderedPair extends Util {
    public static void main(String... args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
//        boolean same = Util.<Integer, String>compare(p1, p2);
        /* type inference */
        boolean same = Util.compare(p1, p2);
        System.out.println(same);
    }
}

public class GenericTypes {
}

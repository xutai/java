package com.company.strings;


public class StringBuilderDemo extends StringDemo {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        sb.reverse();  // reverse it

        System.out.println(sb);

        B b = new B();
        b.main();
    }
}

class A {
    void main() {
        System.out.println("a");
    }
}

class B extends A {
    void main() {
//        System.out.println("b");
    }
}
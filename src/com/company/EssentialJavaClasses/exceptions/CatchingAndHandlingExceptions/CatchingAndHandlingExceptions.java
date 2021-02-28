package com.company.EssentialJavaClasses.exceptions.CatchingAndHandlingExceptions;

// Note: This class will not compile yet.

import java.util.List;
import java.util.ArrayList;



public class CatchingAndHandlingExceptions {
    static void lnHandler() {
        ListOfNumbers ln = new ListOfNumbers();
    }
    public static void main(String[] args) {
       lnHandler();
    }
}

class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

//    public void writeList() {
//        // The FileWriter constructor throws IOException, which must be caught.
//        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//        for (int i = 0; i < SIZE; i++) {
//            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
//            out.println("Value at: " + i + " = " + list.get(i));
//        }
//        out.close();
//    }
}
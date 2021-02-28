package com.company.EssentialJavaClasses.exceptions.CatchingAndHandlingExceptions;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class TheTryBlock {
    private List<Integer> list;
    private static final int SIZE = 10;

    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entered try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }
        catch(Exception e) {
            System.out.printf("%s", e);
        } finally {

        }
    }
    public static void main(String[] args) {
        new TheTryBlock().writeList();
    }
}



package com.company.EssentialJavaClasses.exceptions;

import com.company.EssentialJavaClasses.exceptions.CatchingAndHandlingExceptions.PuttingItAllTogether;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.List;

public class SpecifyingTheExceptionsThrownByAMethod {

    private List<Integer> list;
    private static final int SIZE = 10;

    private void writeList() throws IOException, IndexOutOfBoundsException {
        PrintWriter out = null;

        try {
            System.out.println("Entering" + " try statement");

            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
//                out.println("Value at: " + i + " = ");
//                System.out.println("Value at: " + i + " = ");
                out.println("Value at: " + i + " = " + list.get(i));
//                System.out.println("Value at: " + i + " = " + list.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: "
                    +  e.getMessage());

        } catch (IOException e) {
            System.err.println("Caught IOException: " +  e.getMessage());

        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void main(String[] args) {
        new PuttingItAllTogether().writeList();
    }
}


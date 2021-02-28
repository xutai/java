package com.company.EssentialJavaClasses.exceptions.CatchingAndHandlingExceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TheCatchBlocks {
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
//        catch (IndexOutOfBoundsException e) {
//            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("Caught IOException: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Default Exception: " + e.getMessage());
//        }

        /* Catching More Than One Type of Exception with One Exception Handler */
        catch (IndexOutOfBoundsException|IOException ex) {
            System.err.println("Default Exception: " + ex);
//            logger.log(ex);
//            throw ex;
        }

    }
    public static void main(String[] args) {
        new TheCatchBlocks().writeList();
    }
}





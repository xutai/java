package com.company.EssentialJavaClasses.exceptions.HowToThrowExceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainedExceptions {
    static class SampleException extends IOException {
        SampleException(IOException e) {
            super(e);
            System.err.println("SampleException: " + e);
        }
    }

    private static void writeList() throws SampleException {
        PrintWriter out = null;

        try {
//            out = new PrintWriter(new FileWriter("whatever.txt"));

            File file = new File("whatever.txt");
            // 创建文件
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);
            // 向文件写入内容
            writer.write("This\n is\n an\n example\n");
            writer.flush();
            writer.close();


            FileReader fr = new FileReader("whatevers.txt");
            char[] a = new char[10];
            fr.read(a);
            for (char c : a) {
                System.err.println(c);
            }
            fr.close();
        } catch (IOException e) {
            System.err.println("caught IOException: " + e);
            throw new SampleException(e);
        }
    }

    private static void accessingStackTraceInformation() {
        try {
            FileReader fr = new FileReader("whatevers.txt");
        } catch (Exception cause) {
            StackTraceElement elements[] = cause.getStackTrace();
            for (int i = 0, n = elements.length; i < n; i++) {
                System.err.println(elements[i].getFileName()
                        + ":" + elements[i].getLineNumber()
                        + ">> "
                        + elements[i].getMethodName() + "()");
            }
        }
    }

    private static void tryWriteList() {
        try {
            writeList();
        } catch (SampleException e) {
            System.err.println("caught SampleException: " + e);
        }
    }

    private static void loggingAPI() {
        try {
            Handler handler = new FileHandler("OutFile.log");
            Logger.getLogger("").addHandler(handler);
            FileReader fr = new FileReader("whatevers.txt");

        } catch (IOException e) {
            Logger logger = Logger.getLogger("package.name");
            StackTraceElement elements[] = e.getStackTrace();
            for (int i = 0, n = elements.length; i < n; i++) {
                logger.log(Level.WARNING, elements[i].getMethodName());
            }
        }
    }

    public static void main(String[] args) {
//        accessingStackTraceInformation();
        loggingAPI();
    }
}


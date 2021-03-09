package com.company.EssentialJavaClasses.io.stream.ScanningAndFormatting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) {
        try {
            ScanXan.main();
            ScanSum.main();
        } catch (IOException e) {
            System.err.println("caught error:" + e);
        }
    }
}

class ScanXan {
    public static void main() throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("out.txt")));
            s.useDelimiter(",\\s*");

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}

class ScanSum {
    public static void main() throws IOException {

        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("out.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }
}
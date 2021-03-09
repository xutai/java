package com.company.EssentialJavaClasses.io.stream.ScanningAndFormatting;


public class Formatting {
    public static void main(String[] args) {
        try {
//            Root.main();
//            Root2.main();
            Format.main();
        } catch (Exception e) {
            System.err.println("caught error:" + e);
        }
    }
}

/*The print and println Methods*/

class Root {
    public static void main() {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
    }
}

/*The format Method*/
class Root2 {
    public static void main() {
        int i = 2;
        double r = Math.sqrt(i);
        System.out.format("The square root of %d is %f.%n", i, r);
    }
}

class Format {
    public static void main() {
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        System.out.format("%f, %<+020.10f %n", Math.PI);
    }
}
package com.company.strings;

public class ValueOfDemo {
    public static void main(String[] args) {

        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            System.out.printf("%s%n", Float.valueOf(args[0]));
            System.out.printf("%f%n", Float.valueOf(args[0]).floatValue());
            System.out.printf("%s%n", Float.valueOf(args[0]).floatValue());
            System.out.println(Float.valueOf(args[0]));
            System.out.println(Float.valueOf(args[0]).floatValue());
            System.out.println(Float.parseFloat(args[0]));
            float b = (Float.valueOf(args[1])).floatValue();

            // do some arithmetic
            System.out.println("a + b = " +
                    (a + b));
            System.out.println("a - b = " +
                    (a - b));
            System.out.println("a * b = " +
                    (a * b));
            System.out.println("a / b = " +
                    (a / b));
            System.out.println("a % b = " +
                    (a % b));
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }
    }
}

class ConvertingNumbersToStrings {
    public static void main(String... args) {
        int i = 0;
        double d = 0;
// Concatenate "i" with an empty string; conversion is handled for you.
        String s1 = "" + i;
        // The valueOf class method.
        String s2 = String.valueOf(i);
        String s3 = Integer.toString(i);
        String s4 = Double.toString(d);
    }
}

 class ToStringDemo {

    public static void main(String[] args) {
        double d = 858.48;
        String s = Double.toString(d);

        int dot = s.indexOf('.');

        System.out.println(dot + " digits " +
                "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
                " digits after decimal point.");
    }
}
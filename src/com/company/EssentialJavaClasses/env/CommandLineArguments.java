package com.company.EssentialJavaClasses.env;

import java.util.Map;

public class CommandLineArguments {
    public static void main(String[] args) {
        try {
            String[] strArr = {
                    "Drink",
                    "Hot",
                    "Java"
            };
            String[] intArr = {
                    "1",
                    "2"
            };
            Echo.main(intArr);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class Echo {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
}

class ParsingNumericCommandLineArguments {
    public static void main(String[] args) {
        int firstArg;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
    }
}

/*
 * java Echo Drink Hot Java
 * */
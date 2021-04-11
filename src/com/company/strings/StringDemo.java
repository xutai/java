package com.company.strings;

import java.text.Format;

class StringDemoCreatingStrings {
    public static void main(String[] args) {
        String greeting = "Hello world!";
        char[] helloArray = {'h', 'e', 'l', 'l', 'o', '.'};
        String helloString = new String(helloArray);
        System.out.println(helloString);
    }
}

class StringDemo {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] =
                    palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                    tempCharArray[len - 1 - j];
        }

        String reversePalindrome =
                new String(charArray);
        System.out.println(reversePalindrome);
    }
}

class StringDemoConcatenatingStrings {
    public static void main(String[] args) {
        String string1 = "a";
        String string2 = "b";
        String fs1;
        String cs;
        String cs2;
        fs1 = String.format("%s", string1);
        cs = string1.concat(string2);
        cs2 = "My name is ".concat("Rumplestiltskin");
        System.out.println(fs1);
        System.out.printf("%s%n", cs);
        System.out.printf("%s", cs2);
    }
}
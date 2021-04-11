package com.company.classes;

public class LocalClassExample {

    // access levels - no modifier: package-private
    static String regularExpression = "[^0-9]";

    // method definition
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        // final: never change
        final int numberLength = 10;

        // Valid in JDK 8 and later:

        // int numberLength = 10;

        /* non-static nested class: inner class: local class */
        /*
         * Local classes are classes that are defined in a block,
         * which is a group of zero or more statements between balanced braces.
         * You typically find local classes defined in the body of a method.
         * */
        class PhoneNumber {

            String formattedPhoneNumber = null;

            /* constructor */
            PhoneNumber(String phoneNumber) {
                /* "local variables referenced from an inner class must be final or effectively final"  */
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(
                        regularExpression, "");
                /*
                 * a local class can only access local variables that are declared final.
                 * When a local class accesses a local variable or parameter of the enclosing block, it captures that variable or parameter.
                 * */
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:

            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                        " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:

//        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}

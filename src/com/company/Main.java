package com.company;

import com.company.classes.LocalClassesAreSimilarToInnerClasses;
import com.company.interfaces.polymorphism.Bicycle;

public class Main {

    static void printClassName(Object obj) {
        System.out.println("The object's" + " class is " +
                obj.getClass());
        System.out.println("The object's" + " class's superclass is " +
                obj.getClass().getSuperclass());
        System.out.println("The object's" + " class's interfaces is " +
                obj.getClass().getInterfaces());
        System.out.println("The object's" + " class name is " +
                obj.getClass().getSimpleName());
        Class c = obj.getClass();
        System.out.println(
                c.isAnnotation() + " " +
                        c.isInterface() + " " +
                        c.getFields() + " " +
                        c.getMethods()
        );
    }

    public static void main(String[] args) {
        // write your code here
//        System.out.println("1");
//
//        int computer = 0;
//
//        LocalClassesAreSimilarToInnerClasses lc = new LocalClassesAreSimilarToInnerClasses();
//        lc.sayGoodbyeInEnglish();

        /* The getClass() Method */
        printClassName(new Bicycle(1, 2, 3));
    }
}

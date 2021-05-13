package com.company.classes.LambdaExpressions;

import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        try {
            com.company.classes.LambdaExpressions.RosterTest.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
}


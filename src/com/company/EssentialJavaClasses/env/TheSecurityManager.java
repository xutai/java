package com.company.EssentialJavaClasses.env;


public class TheSecurityManager {
    public static void main(String[] args) {
        try {
            InteractingWithTheSecurityManager.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class InteractingWithTheSecurityManager {
    public static void main(String[] args) {
        SecurityManager appsm = System.getSecurityManager();
        System.out.println(appsm);
    }
}
package com.company.EssentialJavaClasses.concurrency.liveness;

public class StarvationAndLivelock {
    public static void main(String[] args) {
        try {
//            ClassDeadlock.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}



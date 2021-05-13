package com.company.EssentialJavaClasses.concurrency.HighLevelConcurrencyObjects;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
    public static void main(String[] args) {
        try {
            ClassAtomicVariables.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ClassAtomicVariables {
    static class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public void decrement() {
            c--;
        }

        public int value() {
            return c;
        }

    }

    static  class SynchronizedCounter {
        private int c = 0;

        public synchronized void increment() {
            c++;
        }

        public synchronized void decrement() {
            c--;
        }

        public synchronized int value() {
            return c;
        }

    }

    static  class AtomicCounter {
        private final AtomicInteger c = new AtomicInteger(0);

        public void increment() {
            c.incrementAndGet();
        }

        public void decrement() {
            c.decrementAndGet();
        }

        public int value() {
            return c.get();
        }

    }

    public static void main(String[] args) {
        AtomicCounter ac = new AtomicCounter();
        int v = ac.value();
        System.out.format("%s-%s%n", v, ac.value());
        ac.increment();
        ac.increment();
        System.out.format("%s-%s%n", v, ac.value());
        ac.decrement();
        System.out.format("%s-%s%n", v, ac.value());
    }
}


package com.company.EssentialJavaClasses.concurrency.ImmutableObjects;


public class ASynchronizedClassExample {
    public static void main(String[] args) {
        try {
            ClassASynchronizedClassExample.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ClassASynchronizedClassExample {
    public static void main(String[] args) {
        SynchronizedRGB color =
                new SynchronizedRGB(0, 0, 0, "Pitch Black");


        /*
        * original
        * */
//        int myColorInt = color.getRGB();      //Statement 1
//        String myColorName = color.getName(); //Statement 2

        /*
        * If another thread invokes color.set after Statement 1 but before Statement 2,
        * the value of myColorInt won't match the value of myColorName.
        * */
//        int myColorInt = color.getRGB();      //Statement 1
//        color.set(255, 255, 255, "white");
//        String myColorName = color.getName(); //Statement 2

        /*
        * To avoid this outcome, the two statements must be bound together:
        * */
        synchronized (color) {
            int myColorInt = color.getRGB();
            String myColorName = color.getName();
            System.err.println(myColorInt + "" + myColorName);
        }

    }
}

class SynchronizedRGB {

    // Values must be between 0 and 255.
    private int red;
    private int green;
    private int blue;
    private String name;

    private void check(int red,
                       int green,
                       int blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public SynchronizedRGB(int red,
                           int green,
                           int blue,
                           String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public void set(int red,
                    int green,
                    int blue,
                    String name) {
        check(red, green, blue);
        synchronized (this) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.name = name;
        }
    }

    public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void invert() {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
        name = "Inverse of " + name;
    }
}




package com.company.generics;

import javax.swing.*;


/*
 * Raw Types
 * Unchecked Error Messages
 * */

class Box<T> {
    private T i;

    public void set(T t) {
        i = t;
    }
}

class RawTypes {

    class WarningDemo {
    }

    public static void main(String[] args) {
        /* 1 no warning */
        Box<String> stringBox = new Box<>();
        Box rawBox2 = stringBox;
        /* 2 no warning, why? */
        Box rawBox3 = new Box();
        Box<Integer> intBox = rawBox3;
        /* 3 */
        rawBox2.set(8);
        /* 4 */
        Box<Integer> bi;
        bi = createBox();
    }

    @SuppressWarnings(value = "unchecked")
    static Box createBox() {
        return new Box();
    }
}


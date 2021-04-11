package com.company.generics;


public class BoundedTypeParameters {
    public static class Box<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

        public <U extends Number> void inspect(U u) {
            System.out.println("T: " + t.getClass().getName());
            System.out.println("U: " + u.getClass().getName());
        }
    }

    public static class NaturalNumber<T extends Integer> {
        private T n;

        public NaturalNumber(T n) {
            this.n = n;
        }

        public boolean isEven() {
            return n.intValue() % 2 == 0;
        }

        public static void main(String[] args) {
//        NaturalNumber<Integer> nn = new NaturalNumber<Integer>();
        }
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
//            integerBox.inspect("some text");;
        integerBox.inspect(20);
        ;

//        NaturalNumber nn = new NaturalNumber(2);
        NaturalNumber<Integer> nn = new NaturalNumber<Integer>(2);
        nn.isEven();


    }

}
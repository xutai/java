package com.company.generics;

public class MultipleBounds {
    public class A {
        public void sayHi() {
        }

        ;

        public void sayGoodMorning() {
        }

        ;

        public void sayGoodAfternoon() {
        }

        ;

        public void sayGoodNight() {
        }

        ;
    }

    interface B {
        void sayGoodMorning();
    }

    interface C {
        void sayGoodNight();
    }

    class D<T extends A & B & C> {
        public void sayHi() {
        }

        ;

        public void sayGoodMorning() {
        }

        ;
    }

    public static void main(String[] args) {
        MultipleBounds mb = new MultipleBounds();
        D d = mb.new D();
        d.sayHi();
        d.sayGoodMorning();

    }
}

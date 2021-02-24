package com.company.interfaces.interface_methods2;


/* Inherited instance methods from classes can override abstract interface methods. */
public class InterfaceMethods3 {
    public interface Mammal {
        String identifyMyself();
    }
    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    public class Mustang extends Horse implements Mammal {
        public void main(String... args) {
            Mustang myApp = new Mustang();
            System.out.println(myApp.identifyMyself());
        }
    }
    public static void main(String[] args) {
        InterfaceMethods3 im = new InterfaceMethods3();
        Mustang fc = im.new Mustang();
        fc.main();
    }
}

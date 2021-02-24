package com.company.interfaces.interface_methods2;

public class InterfaceMethods {
    public interface Animal {
        /*
        * Methods that are already overridden by other candidates are ignored.
        * This circumstance can arise when supertypes share a common ancestor.
        * */
        default public String identifyMyself() {
            return "I am an animal.";
        }
    }
    public interface EggLayer extends Animal {
        default public String identifyMyself() {
            return "I am able to lay eggs.";
        }
    }
    public interface FireBreather extends Animal {}
    public class Dragon implements EggLayer, FireBreather {
        public void main(String... args) {
            Dragon myApp = new Dragon();
            System.out.println(myApp.identifyMyself());
        }
    }
    public static void main(String[] args) {
        InterfaceMethods im = new InterfaceMethods();
        Dragon d = im.new Dragon();
        d.main();
    }
}

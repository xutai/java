package com.company.interfaces.interface_methods1;

public class InterfaceMethods {
    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    public interface Flyer {
        default public String identifyMyself() {
            return "I am able to fly.";
        }
    }
    public interface Mythical {
        default public String identifyMyself() {
            return "I am a mythical creature.";
        }
    }
    public class Pegasus extends Horse implements Flyer, Mythical {
        public void main(String... args) {
            Pegasus myApp = new Pegasus();
            System.out.println(myApp.identifyMyself());
        }
    }

    public static void main(String... args) {
        InterfaceMethods im = new InterfaceMethods();
        Pegasus p = im.new Pegasus();
        p.main();
    }
}

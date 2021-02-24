package com.company.interfaces.interface_methods2;

/*
* If two or more independently defined default methods conflict,
* or a default method conflicts with an abstract method,
* then the Java compiler produces a compiler error.
* You must explicitly override the supertype methods.
* */
public class InterfaceMethods2 {
    private static class EncryptedKey {
    }
    public interface OperateCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            return 1;
            // Implementation
        }
    }
    public interface FlyCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            return 2;
            // Implementation
        }
    }

    public class FlyingCar implements OperateCar, FlyCar {
        /*
        * The name preceding super must refer to a direct superinterface
        * that defines or inherits a default for the invoked method.
        * This form of method invocation is not restricted to differentiating between multiple implemented interfaces
        * that contain default methods with the same signature
        * You can use the super keyword to invoke a default method in both classes and interfaces
        * */
        public int startEngine(EncryptedKey key) {
            int fc = FlyCar.super.startEngine(key);
            int oc = OperateCar.super.startEngine(key);
            return fc;
        }
    }
    public static void main(String[] args) {
        InterfaceMethods2 im = new InterfaceMethods2();
        FlyingCar fc = im.new FlyingCar();
        EncryptedKey ek = new EncryptedKey();
        int r = fc.startEngine(ek);
        System.out.println(r);
    }
}

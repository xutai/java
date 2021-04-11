package com.company.interfaces.abstract_methods_and_classes;

final class A {
}

/* Cannot inherit from final 'com.company.interfaces.abstract_methods_and_classes.A' */
//class B extends A {}
class C {
    final void cannotBeOverriddenBySubclass() {
    }

    ;
}

class D extends C {
    /* 'cannotBeOverriddenBySubclass()' cannot override 'cannotBeOverriddenBySubclass()' in 'com.company.interfaces.abstract_methods_and_classes.C'; overridden method is final */
//    void cannotBeOverriddenBySubclass(){};
}


public class Main {
    public static void main(String... args) {
        /* 'GraphicObject' is abstract; cannot be instantiated */
//        GraphicObject go = new GraphicObject();

    }
}

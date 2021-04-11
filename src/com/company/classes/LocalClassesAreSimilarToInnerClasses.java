package com.company.classes;

public class LocalClassesAreSimilarToInnerClasses {
    /* You cannot declare an interface inside a block; interfaces are inherently static. */
    //    public void greetInEnglish() {
    //        interface HelloThere {
    //            public void greet();
    //        }
    //        class EnglishHelloThere implements HelloThere {
    //            public void greet() {
    //                System.out.println("Hello " + name);
    //            }
    //        }
    //        HelloThere myGreeting = new EnglishHelloThere();
    //        myGreeting.greet();
    //    }


//    public void sayGoodbyeInEnglish() {
//        class EnglishGoodbye {
//            /* You cannot declare static initializers or member interfaces in a local class. */
//            public static void sayGoodbye() {
//                System.out.println("Bye bye");
//            }
//        }
//        EnglishGoodbye.sayGoodbye();
//    }

    public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            /* A local class can have static members provided that they are constant variables.  */
            /* A constant variable is a variable of primitive type or type String that is declared final and initialized with a compile-time constant expression.  */
            public static final String farewell = "Bye bye";

            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }
}

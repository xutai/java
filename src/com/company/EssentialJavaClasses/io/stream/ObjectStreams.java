package com.company.EssentialJavaClasses.io.stream;

import java.io.*;

public class ObjectStreams {
    public static void main(String[] args) {
        try {
            WriteAndReadObject.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class WriteAndReadObject {
    static final String dataFile = "out.txt";

    public static void main() throws  IOException, ClassNotFoundException {
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataFile)
                        )
                );


        Object ob = new Object();
        out.writeObject(ob);


//        ObjectInputStream in =
//                new ObjectInputStream(
//                        new BufferedInputStream(
//                                new FileInputStream(dataFile)
//                        )
//                );


//        Object ob1 = in.readObject();

    }
}

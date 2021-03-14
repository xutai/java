package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/*Methods for Unbuffered Streams and Interoperable with java.io APIs*/

public class CreatingAndWritingAFileByUsingStreamIO {
    public static void main(String[] args) {
        try {
            CreatingAndWritingAFileByUsingStreamIOClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class CreatingAndWritingAFileByUsingStreamIOClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        // Convert the string to a
        // byte array.
        String s = "Hello World! ";
        byte data[] = s.getBytes();
        Path p = Paths.get(dataFile);

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}

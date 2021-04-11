package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*Methods for Unbuffered Streams and Interoperable with java.io APIs*/

public class ReadingAFileByUsingStreamIO {
    public static void main(String[] args) {
        try {
            ReadingAFileByUsingStreamIOClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ReadingAFileByUsingStreamIOClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        try (
                InputStream in = Files.newInputStream(file);
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(in)
                        )
        ) {
            String line = null;
            while
            (
                    (line = reader.readLine()) != null
            ) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}

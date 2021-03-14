package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingAFileByUsingBufferedStreamIO {
    public static void main(String[] args) {
        try {
            ReadingAFileByUsingBufferedStreamIOClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


class ReadingAFileByUsingBufferedStreamIOClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}

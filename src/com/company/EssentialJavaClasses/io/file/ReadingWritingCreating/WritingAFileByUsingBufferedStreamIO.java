package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingAFileByUsingBufferedStreamIO {
    public static void main(String[] args) {
        try {
            WritingAFileByUsingBufferedStreamIOClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


class WritingAFileByUsingBufferedStreamIOClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        Charset charset = Charset.forName("US-ASCII");
        final String s = "hahaha";
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(s, 0, s.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}

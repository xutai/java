package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingAllBytesOrLinesFromAFile {
    public static void main(String[] args) {
        try {
            ReadingAllBytesOrLinesFromAFileClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ReadingAllBytesOrLinesFromAFileClass {
    static final String dataFile = "out.txt";

    public static void main() throws IOException {
        Path file = Paths.get(dataFile);
        byte[] fileArray;
        fileArray = Files.readAllBytes(file);
        for (byte b: fileArray) {
            System.out.printf("%s%n", b);
        }
    }
}


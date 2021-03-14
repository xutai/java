package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingAllBytesOrLinesToAFile {
    public static void main(String[] args) {
        try {
            WritingAllBytesOrLinesToAFileClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


class WritingAllBytesOrLinesToAFileClass {
    static final String dataFile = "out.txt";

    public static void main() throws IOException {
        Path file = Paths.get(dataFile);
        byte[] buf = "abc".getBytes(Charset.forName("UTF-8"));
        Files.write(file, buf);
    }
}
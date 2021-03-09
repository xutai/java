package com.company.EssentialJavaClasses.io.stream;

import java.io.IOException;

public class BufferedStreams {
    public static void main(String[] args) {
        try {
            copyCharacters.main();
            copyLines.main();
        } catch (IOException e) {
            System.err.println("caught error:" + e);
        }
    }
}

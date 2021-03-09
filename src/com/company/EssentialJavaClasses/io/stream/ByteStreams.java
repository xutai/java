package com.company.EssentialJavaClasses.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {
    public static void main(String[] args) {
        try {
            copyBytes.main();
        } catch (IOException e) {
            System.err.println("caught error:" + e);
        }
    }
}

class copyBytes {
    public static void main() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("in.txt");
            out = new FileOutputStream("out.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

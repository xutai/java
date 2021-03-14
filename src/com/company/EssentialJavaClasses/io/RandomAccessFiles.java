package com.company.EssentialJavaClasses.io;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class RandomAccessFiles {
    public static void main(String[] args) {
        try {
            RandomAccessFilesClass.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}


/*
 *
 * prev:
 * abcabc\n
 *
 * out:
 * abc\n
 *
 * copy:
 * abcabc\n
 *
 * write out,
 * then:
 * abc\nbc\n
 *
 * write copy,
 * now:
 * abc\nbcabcabc\n
 *
 * format it
 * abc
 * bcabcabc
 *
 *
 * */



class RandomAccessFilesClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        String s = "abc\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);
//        String s2 = "def\n";
//        byte data2[] = s2.getBytes();
//        ByteBuffer out2 = ByteBuffer.wrap(data2);
//        System.out.printf("out: %s%n", out);
//        System.out.printf(
//                "out.capacity(): %s - " +
//                        "out.limit(): %s - " +
//                        "out.position(): %s - " +
//                        "out.remaining(): %s %n",
//                out.capacity(),
//                out.limit(),
//                out.position(),
//                out.remaining()
//        );

        ByteBuffer copy = ByteBuffer.allocate(12);
//        System.out.printf("copy: %s%n", copy);
//        System.out.printf(
//                "copy.capacity(): %s - " +
//                        "copy.limit(): %s - " +
//                        "copy.position(): %s - " +
//                        "copy.remaining(): %s %n",
//                copy.capacity(),
//                copy.limit(),
//                copy.position(),
//                copy.remaining()
//        );
//


        try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
            // Read the first 12
            // bytes of the file.
            int nread;
            do {
                nread = fc.read(copy);
//                System.out.printf("nread: %s%n", nread);
            } while (nread != -1 && copy.hasRemaining());

            // Write "I was here!" at the beginning of the file.
//            System.out.printf("fc.position(): %s%n", fc.position());
            fc.position(0);
//            System.out.printf("fc.position(): %s%n", fc.position());
//            System.out.printf("out: %s%n", Charset.forName("UTF-8").decode(out));
            while (out.hasRemaining()) {
//                System.out.printf("out: %s%n", out);
                fc.write(out);
            }

//            System.out.printf(
//                    "out.capacity(): %s - " +
//                            "out.limit(): %s - " +
//                            "out.position(): %s - " +
//                            "out.remaining(): %s %n",
//                    out.capacity(),
//                    out.limit(),
//                    out.position(),
//                    out.remaining()
//            );
//            System.out.printf("%s%n", fc.position());
//            System.out.printf("out: %s%n", out);
//            System.out.printf("%s%n", "out.rewind()");
//            System.out.printf("out: %s%n", Charset.forName("UTF-8").decode(out));
            out.rewind();
//            System.out.printf("out: %s%n", Charset.forName("UTF-8").decode(out));
//            System.out.printf(
//                    "out.capacity(): %s - " +
//                            "out.limit(): %s - " +
//                            "out.position(): %s - " +
//                            "out.remaining(): %s %n",
//                    out.capacity(),
//                    out.limit(),
//                    out.position(),
//                    out.remaining()
//            );
//            System.out.printf("%s%n", fc.position());
//            System.out.printf("out: %s%n", out);

            // Move to the end of the file.  Copy the first 12 bytes to
            // the end of the file.  Then write "I was here!" again.
            long length = fc.size();
//            System.out.printf("length: %s%n", length);
            fc.position(length-1);
//            System.out.printf("%s%n", fc.position());
//            System.out.printf("copy: %s%n", copy);
//            System.out.printf(
//                    "copy.capacity(): %s - " +
//                            "copy.limit(): %s - " +
//                            "copy.position(): %s - " +
//                            "copy.remaining(): %s %n",
//                    copy.capacity(),
//                    copy.limit(),
//                    copy.position(),
//                    copy.remaining()
//            );
//            System.out.printf("%s%n", "copy.flip()");
//            System.out.printf("copy: %s%n", Charset.forName("UTF-8").decode(copy));
            copy.flip();
//            System.out.printf(
//                    "copy.capacity(): %s - " +
//                            "copy.limit(): %s - " +
//                            "copy.position(): %s - " +
//                            "copy.remaining(): %s %n",
//                    copy.capacity(),
//                    copy.limit(),
//                    copy.position(),
//                    copy.remaining()
//            );
//            System.out.printf("copy: %s%n", copy);
//            System.out.printf("copy: %s%n", Charset.forName("UTF-8").decode(copy));
//            for (byte b: copy.array()) {}
            while (copy.hasRemaining())
//            System.out.printf("copy: %s%n", Charset.forName("UTF-8").decode(copy));
                fc.write(copy);
//            System.out.printf(
//                    "copy.capacity(): %s - " +
//                            "copy.limit(): %s - " +
//                            "copy.position(): %s - " +
//                            "copy.remaining(): %s %n",
//                    copy.capacity(),
//                    copy.limit(),
//                    copy.position(),
//                    copy.remaining()
//            );
//            System.out.printf("out: %s%n", Charset.forName("UTF-8").decode(out));
//            while (out.hasRemaining())
//                fc.write(out);
//            System.out.printf(
//                    "out.capacity(): %s - " +
//                            "out.limit(): %s - " +
//                            "out.position(): %s - " +
//                            "out.remaining(): %s %n",
//                    out.capacity(),
//                    out.limit(),
//                    out.position(),
//                    out.remaining()
//            );
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }
}



package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;


public class ReadingAndWritingFilesByUsingChannelIO {
    public static void main(String[] args) {
        try {
//            ReadingAndWritingFilesByUsingChannelIOClass.main();
            LogFilePermissionsTest.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ReadingAndWritingFilesByUsingChannelIOClass {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        // Defaults to READ
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
            ByteBuffer buf = ByteBuffer.allocate(10);

            // Read the bytes with the proper encoding for this platform.  If
            // you skip this step, you might see something that looks like
            // Chinese characters when you expect Latin-style characters.
            String encoding = System.getProperty("file.encoding");
            while (sbc.read(buf) > 0) {
                buf.rewind();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.flip();
            }
        } catch (IOException x) {
            System.out.println("caught exception: " + x);
        }
    }
}

/*
 * main, caught error:java.lang.UnsupportedOperationException:
 * 'posix:permissions' not supported as initial attribute
 * */

class LogFilePermissionsTest {

    public static void main() {

        // Create the set of options for appending to the file.
        Set<OpenOption> options = new HashSet<OpenOption>();
        options.add(APPEND);
        options.add(CREATE);

        // Create the custom permissions attribute.
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);

        // Convert the string to a ByteBuffer.
        String s = "Hello World! ";
        byte data[] = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        Path file = Paths.get("./permissions.log");

        try (SeekableByteChannel sbc =
                     Files.newByteChannel(file, options, attr)) {
            sbc.write(bb);
        } catch (IOException x) {
            System.out.println("Exception thrown: " + x);
        }
    }
}
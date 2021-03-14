package com.company.EssentialJavaClasses.io.file.ReadingWritingCreating;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingRegularAndTemporaryFiles {
    public static void main(String[] args) {
        try {
//            CreatingFiles.main();
            CreatingTemporaryFiles.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class CreatingFiles {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        try {
            // Create the empty file with default permissions, etc.
            Files.createFile(file);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" +
                    " already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }
    }
}

class CreatingTemporaryFiles {
    static final String dataFile = "out.txt";
    static final Path file = Paths.get(dataFile);

    public static void main() {
        try {
            Path tempFile = Files.createTempFile(null, ".myapp");
            System.out.format("The temporary file" +
                    " has been created: %s%n", tempFile)
            ;
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
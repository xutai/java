package com.company.EssentialJavaClasses.io.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.Paths;
import java.nio.file.DirectoryIteratorException;

public class CreatingAndReadingDirectories {
    public static void main(String[] args) {
        try {
//            ListingAFileSystemsRootDirectories.main();
//            CreatingADirectory.main();
//            CreatingATemporaryDirectory.main();
//            ListingADirectorysContents.main();
//            FilteringADirectoryListingByUsingGlobbing.main();
            WritingYourOwnDirectoryFilter.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class ListingAFileSystemsRootDirectories {
    public static void main() {
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {
            System.err.println(name);
        }
    }
}

class CreatingADirectory {
    public static void main() throws IOException {
//        Path dir = Paths.get("D:/java/abc");
//        Files.createDirectory(dir);

//        Set<PosixFilePermission> perms =
//                PosixFilePermissions.fromString("rwxr-x---");
//        FileAttribute<Set<PosixFilePermission>> attr =
//                PosixFilePermissions.asFileAttribute(perms);
//        Files.createDirectory(dir, attr);

//        Path dir = Paths.get("D:/java/abc/def");
        Path dir = Paths.get("abc/def");
        Files.createDirectories(dir);
    }
}

class CreatingATemporaryDirectory {
    public static void main()
            throws IllegalArgumentException, UnsupportedOperationException, IOException {
        /* D:/ */
//        Path dir = Paths.get("/");
        /* D:/java */
        Path dir = Paths.get("");
        Files.createTempDirectory(dir, "aaa");
//        Files.createTempDirectory(null);
    }
}

class ListingADirectorysContents {
    public static void main() {
        Path dir = Paths.get("");
        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.print(file.getFileName() + " ");
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}

class FilteringADirectoryListingByUsingGlobbing {
    public static void main() {
        Path dir = Paths.get("");
        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir, "*.{java,class,jar,txt}")) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can // only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}

class newDirectoryStream {
    static final Path path = Paths.get("");

    abstract static class Filter implements DirectoryStream.Filter {
        //       @Override
        public boolean accept(Object file) {
            System.err.println("3");
            try {
                return (Files.isDirectory(path));
            } catch (Exception x) {
                // Failed to determine if it's a directory.
                System.err.println(x);
                return false;
            }
        }
    }

    ;;
}

class WritingYourOwnDirectoryFilter {
    static final Path file = Paths.get("");
    static final Path path = Paths.get("");
    static final Path dir = Paths.get("");

    public static void main() {

        DirectoryStream.Filter<Path> filter = new newDirectoryStream.Filter() {
            final Path path = Paths.get("");

            @Override
            public boolean accept(Object file) {
                System.err.println("1");
//                return false;
                try {
                    return (Files.isDirectory(path));
                } catch (Exception x) {
                    // Failed to determine if it's a directory.
                    System.err.println(x);
                    return false;
                }
            }

        };


        try (DirectoryStream<Path>
                     stream = Files.newDirectoryStream(dir, filter)) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
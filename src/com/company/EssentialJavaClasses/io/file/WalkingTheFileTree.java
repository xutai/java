package com.company.EssentialJavaClasses.io.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

import static java.nio.file.FileVisitOption.FOLLOW_LINKS;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;
import static java.nio.file.FileVisitResult.TERMINATE;

public class WalkingTheFileTree {
    public static final Path startingDir = Paths.get("");
    public static final Path lookingFor = Paths.get("out.txt");

    public static void main(String[] args) {
        try {
            KickstartingTheProcess();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }

    public static void KickstartingTheProcess() throws Exception {
        /* Kickstarting the Process */
//        PrintFiles pf = new PrintFiles();
//        Files.walkFileTree(startingDir, pf);

        /* Kickstarting the Process */
        EnumSet<FileVisitOption> opts = EnumSet.of(FOLLOW_LINKS);
//        Finder finder = new Finder(pattern);
//         PrintFiles pf = new PrintFiles();
        PrintFiles fileVisitor = new PrintFiles();
        Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, fileVisitor);
    }

    public static class PrintFiles
            extends SimpleFileVisitor<Path> {

        // Print information about
        // each type of file.

//        @Override
//        public FileVisitResult visitFile(Path file,
//                                         BasicFileAttributes attr) {
//            if (attr.isSymbolicLink()) {
//                System.out.format("Symbolic link: %s ", file);
//            } else if (attr.isRegularFile()) {
//                System.out.format("Regular file: %s ", file);
//            } else {
//                System.out.format("Other: %s ", file);
//            }
//            System.out.println("(" + attr.size() + "bytes)");
//            return CONTINUE;
//        }


        /* Controlling the Flow */
        public FileVisitResult
        visitFile(Path file,
                  BasicFileAttributes attr) {
            if (file.getFileName().equals(lookingFor)) {
                System.out.println("Located file: " + file);
                return TERMINATE;
            }
            return CONTINUE;
        }


        // Print each directory visited.
//        @Override
//        public FileVisitResult postVisitDirectory(Path dir,
//                                                  IOException exc) {
//            System.out.format("Directory: %s%n", dir);
//            return CONTINUE;
//        }

        /* Controlling the Flow */
        public FileVisitResult
        preVisitDirectory(Path dir,
                          BasicFileAttributes attrs) {
            if (dir.getFileName().toString().equals("src")) {
                return SKIP_SUBTREE;
            }
            return CONTINUE;
        }


        // If there is some error accessing
        // the file, let the user know.
        // If you don't override this method
        // and an error occurs, an IOException
        // is thrown.

//        @Override
//        public FileVisitResult visitFileFailed(Path file,
//                                               IOException exc) {
//            System.err.println(exc);
//            return CONTINUE;
//        }



        /* Considerations When Creating a FileVisitor */

        @Override
        public FileVisitResult
        visitFileFailed(Path file,
                        IOException exc) {
            if (exc instanceof FileSystemLoopException) {
                System.err.println("cycle detected: " + file);
            } else {
                System.err.format("Unable to copy:" + " %s: %s%n", file, exc);
            }
            return CONTINUE;
        }


    }

}


class TheFileVisitorInterface {
    public static void main() {
    }
}


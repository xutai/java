package com.company.EssentialJavaClasses.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinksSymbolicOrOtherwise {
    public static void main(String[] args) {
        try {
//            CreatingASymbolicLink.main();
//            CreatingAHardLink.main();
//            DetectingASymbolicLink.main();
            FindingTheTargetOfALink.main();
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class CreatingASymbolicLink {
    static final String link = "@";
    static final String targetS = "src";

    public static void main() {
        Path newLink = Paths.get(link);
        Path target = Paths.get(targetS);
        try {
            Files.createSymbolicLink(newLink, target);
        } catch (IOException x) {
            System.err.println(x);
        } catch (UnsupportedOperationException x) {
            // Some file systems do not support symbolic links.
            System.err.println(x);
        }
    }
}

class CreatingAHardLink {
    static final String link = "@";
    static final String targetS = "out";

    public static void main() {
        Path newLink = Paths.get(link);
        Path existingFile = Paths.get(targetS);
        try {
            Files.createLink(newLink, existingFile);
        } catch (IOException x) {
            System.err.println(x);
        } catch (UnsupportedOperationException x) {
            // Some file systems do not
            // support adding an existing
            // file to a directory.
            System.err.println(x);
        }
    }
}

class DetectingASymbolicLink {
    static final String link = "@";
    static final String targetS = "out";

    public static void main() {
        Path newLink = Paths.get(link);
        Path target = Paths.get(targetS);
        boolean isSymbolicLink =
                Files.isSymbolicLink(target);
        System.err.println(isSymbolicLink);
    }
}

class FindingTheTargetOfALink {
    static final String linkS = "@";
    static final String targetS = "out";

    public static void main() {
        Path link = Paths.get(linkS);
        Path target = Paths.get(targetS);
        try {
            System.out.format("Target of link" +
                            " '%s' is '%s'%n", link,
                    Files.readSymbolicLink(link));
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
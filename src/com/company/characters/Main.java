package com.company.characters;

abstract class chars {
    abstract boolean isLetter(char ch);

    abstract boolean isDigit(char ch);

    abstract boolean isWhitespace(char ch);

    abstract boolean isUpperCase(char ch);

    abstract boolean isLowerCase(char ch);

    abstract char toUpperCase(char ch);

    abstract char toLowerCase(char ch);

    abstract String toString(char ch);
}

abstract class charsExtended extends chars {
    void escapeSequences() {
        System.out.println("Insert a tab in the text at this point.\t****");
        System.out.println("Insert a backspace in the text at this point.\b****");
        System.out.println("Insert a newline in the text at this point.\n****");
        System.out.println("Insert a carriage return in the text at this point.\r****");
        System.out.println("Insert a formfeed in the text at this point.\f****");
        System.out.println("Insert a single quote character in the text at this point.\'****");
        System.out.println("Insert a double quote character in the text at this point.\"****");
        System.out.println("Insert a backslash character in the text at this point.\\****");

    }
}

class charsExtendedFinal extends charsExtended {
    boolean isLetter(char ch) {
        System.out.println(Character.isLetter(ch));
        return Character.isLetter(ch);
    }

    ;

    boolean isDigit(char ch) {
        return true;
    }

    ;

    boolean isWhitespace(char ch) {
        return true;
    }

    ;

    boolean isUpperCase(char ch) {
        return true;
    }

    ;

    boolean isLowerCase(char ch) {
        return true;
    }

    ;

    char toUpperCase(char ch) {
        return 's';
    }

    ;

    char toLowerCase(char ch) {
        return 's';
    }

    ;

    String toString(char ch) {
        return Character.toString(ch);
    }

    ;
}

public class Main {

    public static void main(String... args) {
        char ch = 'a';
        // Unicode for uppercase Greek omega character
        char uniChar = '\u03A9';
        // an array of chars
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        Character ch1 = new Character('a');
        charsExtended ce = new charsExtendedFinal();
        ce.isLetter(ch);
        ce.isLetter(ch1);
        ce.escapeSequences();
    }

}

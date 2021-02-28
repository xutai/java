package com.company.generics.wildcards;

import java.util.List;

public class WildcardCaptureAndHelperMethods {
//    public static class WildcardError {
//        void foo(List<?> i) {
//            i.set(0, i.get(0));
//        }
//    }

    public class WildcardFixed {
        void foo(List<?> i) {
            fooHelper(i);
        }
    }

    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}

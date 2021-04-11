package com.company.interfaces.abstract_methods_and_classes;

interface BezierInterface {
    void draw();

    void play();
}

abstract class Bezier implements BezierInterface {
    /* 'draw()' in 'com.company.interfaces.abstract_methods_and_classes.Bezier' clashes with 'draw()' in 'com.company.interfaces.abstract_methods_and_classes.BezierInterface'; attempting to assign weaker access privileges ('private'); was 'public' */
//    private void draw() {};
    /* 'draw()' in 'com.company.interfaces.abstract_methods_and_classes.Bezier' clashes with 'draw()' in 'com.company.interfaces.abstract_methods_and_classes.BezierInterface'; attempting to assign weaker access privileges ('package-private'); was 'public' */
//    void draw() {};
    public void draw() {
    }

    ;
}

class BezierDerived extends Bezier {
    public void play() {
    }

    ;
}

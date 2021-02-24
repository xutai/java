package com.company.interfaces.abstract_methods_and_classes;

public abstract class GraphicObject {
    // declare fields
    int x, y;
    private int a;
    int b;
    public int c;
    static int d;
    /* Variable 'e' might not have been initialized */
//    static final int e;
    protected int f;
    // declare nonabstract methods
    void moveTo(int newX, int newY) {}
    abstract void draw();
    abstract void resize();
}
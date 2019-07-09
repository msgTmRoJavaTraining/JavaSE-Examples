package com.msg.examples.se.interfaces;

public class DefaultExample {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.bah();
    }
}

interface A {
    default void foo() {
        System.out.println("A.foo doo");
    }
}

class ChildClass implements A {
    public void bah() {
        A.super.foo(); //original foo() from A accessed
    }
}

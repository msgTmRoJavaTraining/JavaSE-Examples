package com.msg.examples.se.inheritance;

public abstract class Person {
    private String name;

    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    abstract void dance();

    @Override
    public String toString() {
        return "Person: name: " + name;
    }
}

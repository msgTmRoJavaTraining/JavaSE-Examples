package com.msg.examples.se.inheritance;

public abstract class Person
{
    private String name;

    public Person(String n) {
        this.name=n;
    }

    public abstract void dance();

    public String getName() {
        return name;
    }

}

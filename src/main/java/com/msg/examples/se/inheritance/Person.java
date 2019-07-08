package com.msg.examples.se.inheritance;

public abstract class Person {
    String name;
    public Person(){}
    public Person(String name)
    {
        this.name=name;
    }

    public abstract void dance();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

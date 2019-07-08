package com.msg.examples.se.inheritance;

public abstract class Person {

    protected String name;

    public Person(String n){
        name=n;
    }

    public String getName() {
        return name;
    }



    public abstract void dance();

    public String toString(){
        return "Name: " + name;
    }
}

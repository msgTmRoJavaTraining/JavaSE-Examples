package com.msg.examples.se.inheritance;

abstract class Person {
    private String name;

    public Person(String n){
        name = n;
    }

    public String getName(){return name;}
    public abstract void dance();
}

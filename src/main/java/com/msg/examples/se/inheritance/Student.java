package com.msg.examples.se.inheritance;

public class Student extends Person {

    public Student(String n) {
        super.name=n;
    }

    @Override
    public void dance() {
        System.out.println("I know cool dance moves!");
    }
}

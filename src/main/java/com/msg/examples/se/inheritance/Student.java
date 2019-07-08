package com.msg.examples.se.inheritance;

public class Student extends Person {

    public Student(String n) {
        super.name=n;
    }

    @Override
    public void dance() {
        System.out.println("I know cool dance moves!");
    }

    @Override
    public boolean equals(Object otherObject) {
        Student other = (Student) otherObject;
        if(super.equals(otherObject)&&(name.equals(other.name)))
            return true;
        else return false;
    }
}

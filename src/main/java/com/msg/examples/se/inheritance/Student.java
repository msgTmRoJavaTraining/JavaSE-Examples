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
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;

        Student other = (Student) otherObject;
        return name.equals(other.name);


    }
}

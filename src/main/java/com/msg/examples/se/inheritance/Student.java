package com.msg.examples.se.inheritance;

public class Student extends Person {
    private String facultate;

    public Student(String n, String f) {
        super(n);
        facultate = f;
    }

    public String getFacultate() {
        return facultate;
    }

    @Override
    void dance() {
        System.out.println("Students dance with cool moves :D");
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", facultate: " + facultate;
    }
}

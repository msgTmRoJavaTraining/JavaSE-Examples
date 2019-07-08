package com.msg.examples.se.inheritance;

public class Student extends Person
{
    public Student(String n)
    {
        super(n);
    }

    @Override
    public void dance() {
        System.out.println("Students dance with cool moves");
    }
}

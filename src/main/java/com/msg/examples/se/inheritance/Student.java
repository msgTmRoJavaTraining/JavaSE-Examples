package com.msg.examples.se.inheritance;

public class Student extends Person {
    private String school;
    public Student(String name,String school)
    {
        super(name);
        this.school=school;
    }

    public String getSchool()
    {
        return school;
    }
    @Override
    public void dance()
    {
        System.out.println("Dancing with cool moves");
    }
}

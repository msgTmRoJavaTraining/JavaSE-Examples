package com.msg.examples.se.inheritance;

public class Student extends Person {
    private String university;
    private String faculty;
    public Student(){
        super("student",0);
    }
    public Student(String name, int age, String university, String faculty) {
        super(name, age);
        this.university = university;
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public void dance() {
        System.out.println("Dance status: Cool moves!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + getName()+ " , age: " + getAge() + " , position: " );
        sb.append("Student{" +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}');
        return sb.toString();
    }
}

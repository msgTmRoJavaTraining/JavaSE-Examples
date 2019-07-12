package com.msg.examples.se.dayFive;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(){}

    public Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }


    @XmlAttribute(name ="employee_id")
    public int getIdE() {
        return id;
    }

    public void setIdE(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String nameE) {
        this.name = name;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

package com.msg.examples.se.jaxb.entities;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
public class Employee
{
    private int id;
    private String name;
    private double salary;
    public Employee(){}

    public Employee(int id,String name,double salary){

        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    @XmlAttribute(name="employee_id")
    public int getId()
    {
        return this.id;
    }

}

package com.msg.examples.se.jaxb.entities;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
@Data
public class Department
{
    private int id;
    private List<Employee> list=new ArrayList<>();
    private String name;

    public Department(){}

    public Department(int id, String name, List<Employee> l)
    {
        this.id=id;
        this.name=name;
        this.list=l;
    }


    @XmlAttribute(name="department_id")
    public int getId()
    {
        return this.id;
    }

    @XmlElement(name = "employee")

    public List<Employee> getList() {
        return list;
    }

}

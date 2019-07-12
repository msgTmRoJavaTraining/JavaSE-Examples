package com.msg.examples.se.dayFive;

import com.msg.examples.se.jaxb.entities.Dog;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String name;
    private List<Employee> employees=new ArrayList<>();

    public Department(){}

    public Department(int id,String name,List<Employee> employees){
        this.id=id;
        this.name=name;
        this.employees=employees;
    }



    @XmlAttribute(name="department_id")
    public int getIdD() {
        return id;
    }

    public void setId(int idD) {
        this.id = id;
    }


    @XmlElement(name="department_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}

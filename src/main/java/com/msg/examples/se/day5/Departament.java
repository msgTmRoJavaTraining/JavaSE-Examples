package com.msg.examples.se.day5;

import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@XmlType(propOrder = {"name", "employees"})
public class Departament {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Departament() {
    }

    public Departament(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    @XmlAttribute(name = "departament_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "departament_name")
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

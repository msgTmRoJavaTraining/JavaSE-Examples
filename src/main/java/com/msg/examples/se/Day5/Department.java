package com.msg.examples.se.Day5;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlType(propOrder = {"id","name","employees"})
@XmlRootElement(name = "department")
public class Department {
    private int id;
    private String name;
    private List<Employee>employees;
    public Department(){}
    @XmlAttribute(name = "department_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "department_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElementWrapper(name = "employeeList")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}'+ "\n";
    }
}

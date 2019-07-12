package com.msg.examples.se.fifthDay;

import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"id", "name", "employees"})
@XmlRootElement(name = "departament")
@Setter
public class Departament {
    private String id;
    private String name;
    private List<Employee> employees;

    public Departament() {
    }

    ;

    public Departament(String id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    @XmlAttribute(name = "departament_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "employees_list")
    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee em) {
        employees.add(em);
    }

    @Override
    public String toString() {
        return "\t\t" + this.id + " " + this.name + " \n" + this.employees;
    }
}

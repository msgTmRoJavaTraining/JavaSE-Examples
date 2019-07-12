package com.msg.examples.se.Day5;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"id","location","manager","departments"})
@XmlRootElement(name = "restaurant")
public class Restaurant {
    private int id;
    private String location;
    private Employee manager;
    private List<Department>departments = new ArrayList<>();

    public Restaurant(){}
    @XmlAttribute(name= "restaurant_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @XmlElement(name = "general_manager")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @XmlElementWrapper(name = "restaurant_departments")
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Restaurant(int id, String location, Employee manager) {
        this.id = id;
        this.location = location;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", manager=" + manager +
                ", departments=" + departments +
                '}'+ "\n";
    }
}

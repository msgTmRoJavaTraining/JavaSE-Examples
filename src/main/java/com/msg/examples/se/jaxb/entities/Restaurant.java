package com.msg.examples.se.jaxb.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String location;
    private List<Department> departmentList = new ArrayList<>();
    private Employee generalManager;

    public Restaurant() {
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", departmentList=" + departmentList +
                ", generalManager=" + generalManager +
                '}';
    }

    public Restaurant(int id, String location, Employee generalManager) {
        this.id = id;
        this.location = location;
        this.generalManager = generalManager;
    }

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

    @XmlElementWrapper(name = "restaurant_departments")
    @XmlElement(name = "Department")
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Employee getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(Employee generalManager) {
        this.generalManager = generalManager;
    }
}

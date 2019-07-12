package com.msg.examples.se.dayFive;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String location;
    private Employee generalManager;
    private List<Department> departments= new ArrayList<>();


    public Restaurant(){}

    public Restaurant(int id, String location, Employee generalManager,List<Department> departments) {
        this.id = id;
        this.location = location;
        this.generalManager = generalManager;
        this.departments=departments;
    }


    @XmlAttribute(name="restaurant_id")
    public int getIdD() {
        return id;
    }

    public void setId(int idD) {
        this.id = id;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getGeneralManager() {return generalManager;
    }
    public void setGeneralManager(Employee generalManager){this.generalManager=generalManager;}



    @XmlElementWrapper(name = "restaurant_departments")
    @XmlElement(name = "department")
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}

package com.msg.examples.se.jaxb.entities;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class Restaurant
{
    private int id;
    private String location;
    private Employee generalManager;
    private List<Department> departments=new ArrayList<>() ;

    public Restaurant(int id, String location, Employee generalManager, List<Department> departments) {
        this.id = id;
        this.location = location;
        this.generalManager = generalManager;
        this.departments = departments;
    }

    public Restaurant(){}


    @XmlAttribute(name="restaurant_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElementWrapper(name = "restaurant_departments")

    @XmlElement(name="departament")
    public List<Department> getDepartments() {
        return departments;
    }

}

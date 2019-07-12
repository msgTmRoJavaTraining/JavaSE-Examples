package com.msg.examples.se.day5;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@ToString
@XmlType(propOrder = {"location", "generalManager", "departaments"})
public class Restaurant {
    private int id;
    private String location;
    private Employee generalManager;
    private List<Departament> departaments = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(int id, String location, Employee generalManager, List<Departament> departaments) {
        this.id = id;
        this.location = location;
        this.generalManager = generalManager;
        this.departaments = departaments;
    }

    @XmlAttribute(name = "restaurant_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlElement(name = "generalManager")
    public Employee getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(Employee generalManager) {
        this.generalManager = generalManager;
    }

    @XmlElementWrapper(name = "restaurant_departaments")
    @XmlElement(name = "departament")
    public List<Departament> getDepartaments() {
        return departaments;
    }

    public void setDepartaments(List<Departament> departaments) {
        this.departaments = departaments;
    }
}

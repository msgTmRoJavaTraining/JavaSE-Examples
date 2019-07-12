package com.msg.examples.se.fifthDay;

import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"id", "location", "manager", "departaments"})
@XmlRootElement(name = "dog")
@Setter
public class Restaurant {
    private String id;
    private String location;
    private Employee manager;
    private List<Departament> departaments;

    public Restaurant() {
    }

    ;

    public Restaurant(String Id, String location) {
        this.id = Id;
        this.location = location;
        this.departaments = new ArrayList<>();
    }

    @XmlAttribute(name = "restaurant_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @XmlElementWrapper(name = "restaurant_departaments")
    @XmlElement(name = "departament")
    public List<Departament> getDepartaments() {
        return departaments;
    }

    @Override
    public String toString() {
        return "\t" + this.id + " " + this.location + "\n\tmanager: " + this.manager + ":" + this.departaments;
    }
}

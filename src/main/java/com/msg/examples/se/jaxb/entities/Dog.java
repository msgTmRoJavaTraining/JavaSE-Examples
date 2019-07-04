package com.msg.examples.se.jaxb.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id","type","name"})
@XmlRootElement(name = "dog")
public class Dog {
    private int id;
    private String name;
    private String type;

    public Dog(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Dog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "nume")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

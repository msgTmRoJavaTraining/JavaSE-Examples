package com.msg.examples.se.jaxb.entities;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@XmlRootElement
@XmlType(propOrder = {"id", "name", "dogs"})
public class Dogstore {
    private int id;
    private String name;

    private List<Dog> dogs = new ArrayList<>();

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "dogList")
    @XmlElement(name = "dog")
    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public Dogstore() {

    }

    public Dogstore(int id, String name) {

        this.id = id;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(id).append(" ").append(name).append(" ");
//        dogs.forEach(dog -> stringBuilder.append(dog.getName()).append(" "));
//        return stringBuilder.toString();
//    }
}

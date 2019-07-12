package com.msg.examples.se.day5;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@ToString
@XmlRootElement
public class FranchiseNetwork {
    private List<Restaurant> restaurants = new ArrayList<>();

    public FranchiseNetwork() {
    }

    public FranchiseNetwork(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @XmlElementWrapper(name = "restaurants")
    @XmlElement(name = "restaurant")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}

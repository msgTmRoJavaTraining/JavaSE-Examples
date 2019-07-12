package com.msg.examples.se.jaxb.entities;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@Data
@XmlRootElement(name = "franchise_network")
public class FranchiseNetwork {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    @XmlElementWrapper(name="franchise")

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }


    public FranchiseNetwork(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public FranchiseNetwork() {
    }
}
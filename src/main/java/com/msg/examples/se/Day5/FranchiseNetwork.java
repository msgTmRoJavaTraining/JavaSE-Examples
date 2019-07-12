package com.msg.examples.se.Day5;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "franchise_network")
public class FranchiseNetwork {
    private List<Restaurant>restaurants;
    public FranchiseNetwork(){}
    @XmlElementWrapper(name = "restaurants_list")
    @XmlElement(name = "restaurant")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "FranchiseNetwork{" +
                "restaurants=" + restaurants +
                '}'+ "\n";
    }
}

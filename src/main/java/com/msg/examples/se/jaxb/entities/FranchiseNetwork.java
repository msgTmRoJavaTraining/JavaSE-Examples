package com.msg.examples.se.jaxb.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class FranchiseNetwork {
    private List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public String toString() {
        return "FranchiseNetwork{" +
                "restaurantList=" + restaurantList +
                '}';
    }

    @XmlElementWrapper(name = "RestaurantList")
    @XmlElement(name = "Restaurant")
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public FranchiseNetwork() {
    }

    public FranchiseNetwork(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}

package com.msg.examples.se.dayFive;

import com.msg.examples.se.jaxb.entities.Dog;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="FranchiseNetwork")
public class FranchiseNetwork {

    private List<Restaurant> restaurants = new ArrayList<>();

    public FranchiseNetwork(){}

    public void addRest(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() { return restaurants; }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}

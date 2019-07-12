package com.msg.examples.se.fifthDay.xml;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Franchise")
@Setter
public class FranchiseNetwork {
    private List<Restaurant> restaurants = new ArrayList<>();

    @XmlElementWrapper(name="restaurants_list")
    @XmlElement(name= "restaurant")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public String toString(){
        return " "+ this.restaurants;
    }
}

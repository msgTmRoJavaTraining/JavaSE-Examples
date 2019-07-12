package com.msg.examples.se.fifthDay;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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

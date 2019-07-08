package com.msg.examples.se.firstPack;

public class Hamburger
{

    private String name;
    private double weight;
    private String expDate;

   /* public Hamburger(String name, double weight, String expDate) {
        this.name = name;
        this.weight = weight;
        this.expDate = expDate;
    }
   */

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void weightRaise(double x)
    {
        double raise= x/100*this.weight;
        this.weight+=raise;
    }
}

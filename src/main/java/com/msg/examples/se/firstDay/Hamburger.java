package com.msg.examples.se.firstDay;

public class Hamburger {
    private String name;
    private double weight;
    private String expirationDate;

    public Hamburger(String name, double weight, String expirationDate) {
        this.name = name;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
    public void changeWeight(int x){
        this.weight = (x/100) * this.weight;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}

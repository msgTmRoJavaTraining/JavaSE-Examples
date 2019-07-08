package com.msg.examples.se.firstDay;

public class Hamburger {
    private String name;
    private float weight;
    private String expiration_date;

    public Hamburger(String name, int weight, String expiration_date) {
        this.name = name;
        this.weight = weight;
        this.expiration_date = expiration_date;
    }

    public String getName() {
        return name;
    }

    public void setWeight(float weight) {
        this.weight += weight/100 * this.weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", expiration_date='" + expiration_date + '\'' +
                '}';
    }
}

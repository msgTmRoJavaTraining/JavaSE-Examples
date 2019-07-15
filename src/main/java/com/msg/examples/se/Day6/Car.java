package com.msg.examples.se.Day6;

import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialversionUID = 129348938L;
    transient String lastOwnerName;
    private int noSeats;
    private String brand;
    private boolean gass;

    public Car(String lastOwnerName, int noSeats, String brand, boolean gass) {
        this.lastOwnerName = lastOwnerName;
        this.noSeats = noSeats;
        this.brand = brand;
        this.gass = gass;
    }

    public String getLastOwnerName() {
        return lastOwnerName;
    }

    public void setLastOwnerName(String lastOwnerName) {
        this.lastOwnerName = lastOwnerName;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isGass() {
        return gass;
    }

    public void setGass(boolean gass) {
        this.gass = gass;
    }

    @Override
    public String toString() {
        return "Car{" +
                "lastOwnerName='" + lastOwnerName + '\'' +
                ", noSeats=" + noSeats +
                ", brand='" + brand + '\'' +
                ", gass=" + gass +
                '}';
    }
}

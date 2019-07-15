package com.msg.examples.se.week2d1.IOstuff.first2;

import java.io.Serializable;


class Car implements Serializable {
    private static final long serialversionUID = 111;
    private String marca;
    private int seats;
    private String color;
    private transient String cid;

    public Car(String marca, int seats, String color, String cid) {
        this.marca = marca;
        this.seats = seats;
        this.color = color;
        this.cid = marca+":"+cid;
    }
    public static long getSerialversionUID() {
        return serialversionUID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}

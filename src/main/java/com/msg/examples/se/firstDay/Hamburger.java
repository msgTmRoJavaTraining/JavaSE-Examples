package com.msg.examples.se.firstDay;

public class Hamburger{

    private String name;
    private double weight;
    private String expirationDate;
//    public Hamburger(String name,double weight,String expirationDate){
//
//        this.name = name;
//        this.weight = weight;
//        this.expirationDate = expirationDate;
//    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    public double setPercentWeight(double  x){

        this.weight = this.weight + x*this.weight/100;
        return this.weight;
    }

    public String getName(){

        return this.name;
    }

    public double getWeight(){

        return this.weight;
    }
}

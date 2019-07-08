package com.msg.examples.se.firstDay;

public class Hamburger {

    private String name;
    private int weight;
    private String date;



    public String getName(){
        return name;
    }

    public void setName( String name){
        this.name=name;
    }


    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight=weight;
    }

    public void newWeight(int x){

        weight += x*weight/100;

    }
     public static void main(String [] args){
        Hamburger h1=new Hamburger();
        Hamburger h2=new Hamburger();
        Hamburger h3=new Hamburger();

        h1.setWeight(100);
        h1.newWeight(30);
        h2.setName("Papa");
        h3.setWeight(100);

       System.out.println( h1.getWeight());
        System.out.println(h2.getName());
        System.out.println(h3.getWeight());

     }
}

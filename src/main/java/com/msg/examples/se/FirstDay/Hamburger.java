package com.msg.examples.se.FirstDay;

public class Hamburger {
    private String name;
    private double weight;
    private String expire;

    public String getName()
    {
        return name;
    }
    public double getWeight()
    {
        return weight;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setWeight(double weight)
    {
        this.weight=weight;
    }
    public void setExpire(String expire)
    {
        this.expire=expire;
    }
    public double raise(double x)
    {
        this.weight=this.weight+x;
        return this.weight;
    }
}

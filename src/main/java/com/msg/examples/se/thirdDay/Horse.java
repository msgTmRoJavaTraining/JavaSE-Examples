package com.msg.examples.se.thirdDay;

public class Horse implements Animal {

    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("I run faster than you, even if I'm bigger than you.");
    }
}

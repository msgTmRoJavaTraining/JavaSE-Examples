package com.msg.examples.se.thirdDay;

public interface Animal {
    default void run() {
        System.out.println("An animal runs");
    }
}

package com.msg.examples.se.objectsAndClasses.handson3;

public class PassByValue {
    int i = 1;

    void addOne(PassByValue passByValue) {
        ++passByValue.i;
    }

    void addOne(int i) {
        ++i;
    }

    public static void main(String[] args) {
        PassByValue passByValue = new PassByValue();
        int a = 1;
        passByValue.addOne(a);
        System.out.println(a); //value doesn't change - copy of the parameter is increased, actual parameter doesn't change

        passByValue.addOne(passByValue); //will print 2 - copy of the reference, but pointing to the same object
        System.out.println(passByValue.i);
    }
}

package com.msg.examples.se.day6;

public class MyExceptionGenerator {
    public NullPointerException throwException1() {
        throw new NullPointerException();
    }

    public ArrayIndexOutOfBoundsException throwException2() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public NumberFormatException throwException3() {
        throw  new NumberFormatException();
    }
}

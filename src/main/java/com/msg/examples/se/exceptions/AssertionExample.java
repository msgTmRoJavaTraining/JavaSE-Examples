package com.msg.examples.se.exceptions;

@SuppressWarnings("ALL")
public class AssertionExample {
    public static void main(String[] args) {
        trueAssertion();
        messageAssertion(7);
    }

    private static void messageAssertion(int i) {
        assert i < 6 : "Input " + 7;
    }

    private static void trueAssertion() {
        assert 0 == 0;
    }
}

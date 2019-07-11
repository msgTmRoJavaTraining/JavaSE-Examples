package com.msg.examples.se.day4;

public class InvalidLineFormatException extends Exception {
    private String givenSentence;
    private int lineNumber;

    public InvalidLineFormatException(String errorMessage, String sentence, int line) {
        super(errorMessage);
        givenSentence = sentence;
        lineNumber = line;
    }

    public String getGivenSentence() {
        return givenSentence;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}

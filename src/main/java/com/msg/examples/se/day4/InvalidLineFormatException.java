package com.msg.examples.se.day4;

public class InvalidLineFormatException extends Exception {
    public InvalidLineFormatException() { super(); }
    public InvalidLineFormatException(String message) { super(message); }
    public InvalidLineFormatException(String message, Throwable cause) { super(message, cause); }
    public InvalidLineFormatException(Throwable cause) { super(cause); }
}

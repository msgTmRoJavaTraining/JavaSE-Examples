package com.msg.examples.se.Day6;
import java.io.FileNotFoundException;

public class ExceptionThrowing {
    public static void throwFileNotFoundException()throws FileNotFoundException {
        throw new FileNotFoundException();
    }
    public static void throwIndexOutOfBoundsException()throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException();
    }
    public static void throwArrayIndexOutOfBoundsException()throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }
}

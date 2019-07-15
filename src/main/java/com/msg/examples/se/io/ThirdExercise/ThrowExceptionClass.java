package com.msg.examples.se.io.ThirdExercise;

import sun.awt.SunToolkit;

public class ThrowExceptionClass {

    public static String getNullPointerException() throws NullPointerException{
        throw new NullPointerException();
    }

    public static String getIndexOutOfBoundsException() throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException();
    }

    public static String getArithmeticException() throws ArithmeticException{
        throw new ArithmeticException();
    }

    public static String getIlegalThread() throws IllegalThreadStateException{
        throw new IllegalThreadStateException();
    }
}

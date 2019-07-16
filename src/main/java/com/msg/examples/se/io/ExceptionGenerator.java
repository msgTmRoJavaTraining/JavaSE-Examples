package com.msg.examples.se.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;

public class ExceptionGenerator
{

    public static void ex1() throws NullPointerException
    {
        throw new NullPointerException();
    }

    public static void ex2() throws InterruptedException {
        throw new InterruptedException();
    }

    public static void ex3()
    {
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) throws IOException {

        try
        {
            ex1();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("one.log"));
           writer.write(e.toString()+"   "+String.valueOf(e.getStackTrace()));
           writer.close();
        }

        try
        {
            ex2();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("two.log"));
            writer.write(e.toString()+"   "+String.valueOf(e.getStackTrace()));
            writer.close();

        }

        try
        {
            ex3();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("three.log"));

            writer.write(e.toString()+"   "+String.valueOf(e.getStackTrace()));
            writer.close();
        }

    }

}

package com.msg.examples.se.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;

class SpecialCase extends Exception
{
    SpecialCase(String s)
    {
        super(s);
    }
}
public class ExceptionGenerator
{

    public static void ex1() throws SpecialCase
    {
        throw new SpecialCase("Prima exceptie");
    }

    public static void ex2() throws SpecialCase
    {
        throw new SpecialCase("A doua exceptie");
    }

    public static void ex3() throws SpecialCase
    {
        throw new SpecialCase("A treia exceptie");
    }

    public static void main(String[] args) throws IOException {

        try
        {
            ex1();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("one.log"));
           writer.write(e.getMessage()+"   "+String.valueOf(e.getStackTrace()));
           writer.close();
        }

        try
        {
            ex2();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("two.log"));
            writer.write(e.getMessage()+"   "+String.valueOf(e.getStackTrace()));
            writer.close();

        }

        try
        {
            ex3();
        }
        catch (Exception e)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("three.log"));

            writer.write(e.getMessage()+"   "+String.valueOf(e.getStackTrace()));
            writer.close();
        }

    }

}

package com.msg.examples.se.DaySix;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void exceptionOne() throws IOException{
        throw new IOException("\nExceptionOne");
    }
    public void exceptionTwo() throws NullPointerException{
        throw new NullPointerException("\nExceptionTwo");
    }
    public void exceptionThree() throws FileNotFoundException {
        throw new FileNotFoundException("\nExceptionThree");
    }

    public static void main(String[] args) throws IOException {

        WriteFile file = new WriteFile();

        try{
            file.exceptionOne();
        }catch(IOException e){
            BufferedWriter writer = new BufferedWriter(new FileWriter("fileOne.log"));
            writer.write(String.valueOf(e.getStackTrace()));
            writer.write(String.valueOf(e.getMessage()));
            writer.close();
        }

        try{
            file.exceptionTwo();
        }
        catch(NullPointerException e){
            BufferedWriter writer = new BufferedWriter(new FileWriter("fileTwo.log"));
            writer.write(String.valueOf(e.getStackTrace()));
            writer.write(String.valueOf(e.getMessage()));
            writer.close();
        }

        try{
            file.exceptionThree();
        }catch(FileNotFoundException e){
            BufferedWriter writer = new BufferedWriter(new FileWriter("fileThree.log"));
            writer.write(String.valueOf(e.getStackTrace()));
            writer.write(String.valueOf(e.getMessage()));
            writer.close();
        }
    }


}

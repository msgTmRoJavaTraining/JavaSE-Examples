package com.msg.examples.se.week2d1.IOstuff.last1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitor;

public class MainApp {
    public static void main(String[] args) throws IOException {
        FileWriter log1=new FileWriter("LogFile1.log");
        FileWriter log2=new FileWriter("LogFile2.log");
        FileWriter log3=new FileWriter("LogFile3.log");
        TestClass tCls=new TestClass();

        try{
            tCls.exceptOne();
        }catch(FileNotFoundException e){
           log1.write(e.getMessage()+e.getStackTrace());
           log1.close();
        }
        try{
            tCls.exceptTwo();
        }catch(NumberFormatException e){
            log2.write(e.getMessage()+e.getStackTrace());
            log2.close();
        }
        try{
            tCls.exceptThree();
        }catch(Exception e){
            log3.write(e.getMessage()+e.getStackTrace());
            log3.close();
        }




    }
}

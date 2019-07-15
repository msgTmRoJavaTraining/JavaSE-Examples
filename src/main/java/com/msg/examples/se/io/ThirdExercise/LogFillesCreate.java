package com.msg.examples.se.io.ThirdExercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LogFillesCreate {

    public static void main(String[] args){

        String file1 = "C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\ThirdExercise\\logFile1.log";
        String file2 = "C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\ThirdExercise\\logFile2.log";
        String file3 = "C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\ThirdExercise\\logFile3.log";
        try (FileWriter f1 = new FileWriter(file1)) {
            try{ThrowExceptionClass.getNullPointerException();
              }catch (NullPointerException e1){
                f1.write(String.valueOf(e1.getStackTrace())+e1.toString());

            }
        }catch (IOException e){
            e.getStackTrace();
        }

        try (FileWriter f2 = new FileWriter(file2)) {
            try{ThrowExceptionClass.getIndexOutOfBoundsException();
            }catch (IndexOutOfBoundsException e1){
                f2.write(String.valueOf(e1.getStackTrace())+e1.toString());

            }
        }catch (IOException e){
            e.getStackTrace();
        }

        try (FileWriter f3 = new FileWriter(file3)) {
            try{ThrowExceptionClass.getIlegalThread();
            }catch (IllegalThreadStateException e1){
                f3.write(String.valueOf(e1.getStackTrace())+e1.toString());

            }
        }catch (IOException e){
            e.getStackTrace();
        }




    }
}

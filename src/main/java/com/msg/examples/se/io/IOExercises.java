package com.msg.examples.se.io;
import java.io.File;
import java.io.FileInputStream;

public class IOExercises {
    public static void main(String[] args)
    {

        File file = new File("C:\\Users\\borozi\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\io\\myFile.txt");
        String mySting = new String(readContentIntoByteArray(file));
        System.out.println(mySting);
    }

    private static byte[] readContentIntoByteArray(File file)
    {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bFile;
    }
}

package com.msg.examples.se.day6;

import com.mysql.cj.jdbc.util.BaseBugReport;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ExercitiiInputOutput extends SimpleFileVisitor<Path> {
    public static final String PACKAGE_PATH = "C:\\Users\\astana\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\day6\\files";

    public static void main(String[] args) {
        //Exercitiul 1
        System.out.println("Exercitiul 1");
        exercitiul1();

        //Exercitiul 2
        System.out.println("\nExercitiul 2");
        exercitiul2();

        //Exercitiul 3
        System.out.println("\nExercitiul 3");
        exercitiul3();
    }

    private static void exercitiul1() {
        String fileName = PACKAGE_PATH + "\\fileIOExercitiul1.txt";
        File file = new File(fileName);

        InputStream fileReader = null;

        try {
            fileReader = new FileInputStream(file);
            byte[] fileContentArray = new byte[(int)file.length()];

            while(true) {
                if ((fileReader.read(fileContentArray)) <= 0) break;
            }

            String byteArrayToString = new String(fileContentArray);
            System.out.println("Continutul Byte Array:\n" + byteArrayToString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exercitiul2() {
        Car newCar = new Car("Skoda", 28000.00, true, 5, 5);
        File fileName = new File(PACKAGE_PATH + "\\fileIOExercitiul2.txt");

        InputStream inputStream = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        //Serialization
        try {
            outputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(newCar);

            objectOutputStream.close();
            outputStream.close();

            System.out.println("Car object serialized.\nData before serialization:\n" + newCar.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialization
        newCar = null;
        try {
           inputStream = new FileInputStream(fileName);
           objectInputStream = new ObjectInputStream(inputStream);

           newCar = (Car) objectInputStream.readObject();

           objectInputStream.close();
           inputStream.close();

            System.out.println("\nCar object deserialized.\nData after serialization:\n" + newCar.toString());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void exercitiul3() {
        MyExceptionGenerator myExceptions = new MyExceptionGenerator();
        adaugareExceptiiInFisiere(myExceptions);

        try {
            Path currentDirectory = Paths.get(PACKAGE_PATH);
            Files.walkFileTree(currentDirectory, new ExercitiiInputOutput());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void adaugareExceptiiInFisiere(MyExceptionGenerator myExceptions) {
        //Exceptia 1
        try {
            myExceptions.throwException1();
        } catch (NullPointerException e1) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(PACKAGE_PATH  + "\\fileIOExercitiul3_1.log", true));
                writer.append("Exception - NullPointerException detected!\n" + e1.getStackTrace());
                writer.append('\n');

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Exceptia 2
        try {
            myExceptions.throwException2();
        } catch (ArrayIndexOutOfBoundsException e2) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(PACKAGE_PATH  + "\\fileIOExercitiul3_2.log", true));
                writer.append("Exception - ArrayIndexOutOfBoundsException detected!\n" + e2.getStackTrace());
                writer.append('\n');

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Exceptia 3
        try {
            myExceptions.throwException3();
        } catch (NumberFormatException e3) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(PACKAGE_PATH  + "\\fileIOExercitiul3_3.log", true));
                writer.append("Exception - NumberFormatException detected!\n" + e3.getStackTrace());
                writer.append('\n');

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toString().endsWith(".log")) {
            System.out.println("Log file found!");
            InputStream is = new FileInputStream(String.valueOf(file));
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();

            if(fileAsString.contains("Exception")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_PATH + "\\allExceptionsFile.txt", true));
                writer.append(fileAsString);
                writer.append("\n");
                writer.close();
            }
        }
        return FileVisitResult.CONTINUE;
    }
}

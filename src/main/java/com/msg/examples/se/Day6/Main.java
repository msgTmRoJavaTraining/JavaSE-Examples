package com.msg.examples.se.Day6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.ChronoUnit.YEARS;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TempAdjuster classAdjuster = new TempAdjuster();
        LocalDate startProject;
        LocalDate now = LocalDate.of(2019,7, 8);
        LocalDate lastDayOfTraining;
        if(now.getDayOfWeek()!= DayOfWeek.MONDAY){
            now=now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }
        lastDayOfTraining = now.with(classAdjuster);
        System.out.println("Exercise1 --DateAndTime--");
        System.out.println("Last day of training is: " + lastDayOfTraining);
        startProject= lastDayOfTraining.minus(2, ChronoUnit.WEEKS);
        if(startProject.getDayOfWeek()!= DayOfWeek.MONDAY){
            startProject = startProject.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        System.out.println("Project start date is: " + startProject);
        System.out.println("The chinese sign for the year " + now.plus(2,YEARS).getYear()+  " is : "+ now.plus(2, YEARS).query(YearQuery::findChineseYear));

        System.out.println("\nExercise1 --IO--");
        File file = new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\test.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int)file.length()];
            fin.read(fileContent);
            String s = new String(fileContent);
            System.out.println("File content: \n" + s);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        }
        finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
        }
        System.out.println("\nExercise2 --IO-:");
        Car car1 = new Car("aaa", 4, "BMW", false);
        File fs= new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\car.txt");
        try {

            FileOutputStream fos = new FileOutputStream(fs);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(car1);

            oos.close();
            fos.close();

            System.out.println("Object before deserialization: ");
            System.out.print(car1);
            car1.lastOwnerName = "someone";
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        car1 = null;
        try {
            FileInputStream fis = new FileInputStream(fs);
            ObjectInputStream in = new ObjectInputStream(fis);
            car1 = (Car) in.readObject();
            in.close();
            fis.close();
            System.out.println("\nObject after deserialization:");
            System.out.print(car1);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
        int contor = 0;
        try{
            ExceptionThrowing.throwArrayIndexOutOfBoundsException();
        }catch (Exception e) {
            contor+=1;
            String exceptionMessage = e.getMessage();
            String exceptionStackTrace= e.getStackTrace().toString();
            String dataToInsert = "Exception" +  exceptionMessage+ exceptionStackTrace;
            File exceptionFile = new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\exception" + contor +".log");
            FileOutputStream fos = new FileOutputStream(exceptionFile);
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(dataToInsert);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try{
            ExceptionThrowing.throwFileNotFoundException();

        }catch (Exception e) {
            contor+=1;
            String exceptionMessage = e.getMessage();
            String exceptionStackTrace= e.getStackTrace().toString();
            String dataToInsert = "Exception" + exceptionMessage+ exceptionStackTrace;
            File exceptionFile = new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\exception" + contor +".log");
            FileOutputStream fos = new FileOutputStream(exceptionFile);
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(dataToInsert);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try{
            ExceptionThrowing.throwIndexOutOfBoundsException();

        }catch (Exception e) {
            contor+=1;
            String exceptionMessage = e.getMessage();
            String exceptionStackTrace= e.getStackTrace().toString();
            String dataToInsert = "Exception" + exceptionMessage+ exceptionStackTrace;
            File exceptionFile = new File("C:\\Users\\nicoll\\IdeaProjects\\JavaSE-Examples\\src\\main\\java\\com\\msg\\examples\\se\\Day6\\exception" + contor +".log");
            FileOutputStream fos = new FileOutputStream(exceptionFile);
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(dataToInsert);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            Path startingDir = Paths.get("..");
            Files.walkFileTree(startingDir, new FileVisitor());
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private static byte[] readFileToByteArray(File file){
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        return bArray;
    }
}

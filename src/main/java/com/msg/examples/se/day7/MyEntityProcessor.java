package com.msg.examples.se.day7;

import com.msg.examples.se.annotation.Annotated;
import com.sun.tools.javac.Main;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.msg.examples.se.day7.*")
public class MyEntityProcessor extends AbstractProcessor {
    Connection connection;

    public MyEntityProcessor() {
    }

    private String checkForExistingTable() {
        return "DROP TABLE IF EXISTS angajati;";
    }

    private String generateTable(Element annotated) {
        String finalString = "CREATE TABLE `angajati` (";

        try {
            Class<?> curentClass = Class.forName(annotated.toString());
            for(Field field : curentClass.getDeclaredFields()) {
                String newLine;

                switch (field.getType().toString()) {
                    case "class java.lang.String":
                        newLine = "\n`" + field.getName() + "` VARCHAR(64) DEFAULT NULL,";
                        finalString += newLine;
                        break;

                    case "double":
                        newLine = "\n`" + field.getName() + "` DECIMAL(10, 2) DEFAULT NULL,";
                        finalString += newLine;
                        break;

                    case "int":
                        newLine = field.getName().equals("id") ? "`" + field.getName() + "` INT(11) NOT NULL AUTO_INCREMENT, " : "\n`" + field.getName() + "` INT(11) NOT NULL,";
                        finalString += newLine;
                        break;

                    default:
                        break;
                }
            }

            finalString += "\nPRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return finalString;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }



    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            return true;
        }

        if (annotations.isEmpty()) {
            return false;
        }

        //Pentru toate anotarile disponibile
        for(TypeElement element : annotations) {
            //Cautam toate clasele corespunzatoare
            for(Element annotatedClass : roundEnv.getElementsAnnotatedWith(element)) {

                try {
                    Statement checkTableStatement = connection.createStatement();
                    Statement generateTableStatement = connection.createStatement();

                    checkTableStatement.executeUpdate(checkForExistingTable());


                    boolean something = generateTableStatement.execute(generateTable(annotatedClass));
                    System.out.println("Tabel Generat cu succes in baza de date dupa urmatoarea schema:\n" + generateTable(annotatedClass));
                    return something;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        String[] arguments = {
            "-proc:only", "-processor", "com.msg.examples.se.day7.MyEntityProcessor", "com.msg.examples.se.day7.MyClass"
        };

        Main.main(arguments);
    }
}

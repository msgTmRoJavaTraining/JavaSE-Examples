package com.msg.examples.se.annotation.Exercise;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Exercise.Annotations.*"})
@SupportedOptions({"debug", "verify"})
public class MyProcessor extends AbstractProcessor {

    private Connection connection;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MyProcessor() {
    }

    public String dropTableIfExists() {
        return "drop table if exists angajati;";
    }

    public String generateTableString(Element annotated) {

        String createTable =
                "CREATE TABLE `angajati` (";
        try {
            String newLine;

            Class<?> entityClass = Class.forName(annotated.toString());
            for (Field entityField : entityClass.getDeclaredFields()) {
                switch (entityField.getType().toString()) {
                    case ("class java.lang.String"):
                        newLine = "\n  `" + entityField.getName() + "` varchar(64) DEFAULT NULL,";
                        createTable += newLine;
                        break;
                    case ("double"):
                        newLine = "\n  `" + entityField.getName() + "` DECIMAL(10,2) DEFAULT NULL,";
                        createTable += newLine;
                        break;
                    case ("int"):
                        newLine = entityField.getName().equals("id") ? "\n  `" + entityField.getName() + "` int(11) NOT NULL AUTO_INCREMENT," : "\n  `" + entityField.getName() + "` int(11) NOT NULL,";
                        createTable += newLine;
                        break;
                    default:
                        break;
                }
            }
            String finalLines = "\n  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;";

            createTable += finalLines;
            System.out.println(createTable);
            return createTable;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            return true;
        }

        if (annotations.isEmpty()) {
            return false;
        }

        for (TypeElement annotation : annotations) {
            for (Element annotated : roundEnv.getElementsAnnotatedWith(annotation)) {
                log("Found element " + annotated.getKind() + " annotated with " + annotation.getSimpleName() + ": " + annotated.getSimpleName());

                String result = generateTableString(annotated);

                Statement statement = null;

                try {
                    Statement statement2 = connection.createStatement();
                    statement2.execute(dropTableIfExists());

                    statement = connection.createStatement();
                    boolean resultSet = statement.execute(result);
                    return resultSet;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private void log(String msg) {
        processingEnv.getMessager().printMessage(Kind.NOTE, msg);
    }

    public static void main(String args[]) throws Exception {
        String arguments[] = {"-proc:only", "-processor", "com.msg.examples.se.annotation.Exercise.MyProcessor",
                "com.msg.examples.se.annotation.Exercise.Angajat"};
        //Main.main(arguments);
    }
}
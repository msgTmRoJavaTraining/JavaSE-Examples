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


@SupportedAnnotationTypes("com.msg.examples.se.day7.*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {

    Connection connection;


    public String dropTableIfExists(){
        return "DROP TABLE IF EXISTS angajati;";
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public MyProcessor(){}

    public String generateTable(Element annotated){
        String string = "CREATE TABLE `angajati` (";

        try {
            Class<?> entity= Class.forName(annotated.toString());
            String newLine="";

            for(Field field : entity.getDeclaredFields()){

                switch(field.getType().toString()){
                    case("class java.lang.String"):
                        newLine="\n `" + field.getName() + "` VARCHAR(64) DEFAULT NULL,";
                        string+=newLine;
                        break;
                    case("int"):
                        newLine="\n `" + field.getName() + "` INT(11) NOT NULL AUTO_INCREMENT,";
                        string+=newLine;
                        break;
                    case("double"):
                        newLine="\n `" + field.getName()+ "` DECIMAL(10,2) DEFAULT NULL,";
                        string+=newLine;
                        break;
                }
            }

        string += "\n PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;";

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return string;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if (roundEnv.processingOver()) {
            return true;
        }

        if (annotations.isEmpty()) {
            return false;
        }

        for(TypeElement annotation:annotations) {
            for (Element annotated : roundEnv.getElementsAnnotatedWith(annotation)) {
                Statement statement = null;
                String result=generateTable(annotated);

                try {
                    Statement statement2 = connection.createStatement();
                    statement2.execute(dropTableIfExists());

                    statement = connection.createStatement();
                    boolean resultSet=statement.execute(result);
                    return resultSet;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //System.out.println(generateTable(annotated));
            }
        }
        return false;
    }

    public static void main(String args[]) throws Exception{
       String arguments[] = {"-proc:only","-processor","com.msg.examples.se.day7.MyProcessor","com.msg.examples.se.day7.MyClass"};
       Main.main(arguments);
    }

}

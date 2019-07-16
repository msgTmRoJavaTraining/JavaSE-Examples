package com.msg.examples.se.Day7;

import com.sun.tools.javac.Main;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.msg.examples.se.Day7.*")
public class AnnotationProcessor extends AbstractProcessor {
    private Connection conn;
    public synchronized void init(ProcessingEnvironment pe){
        super.init(pe);
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "root";
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String dropTable(){
        String dropItLikeItsHot= "DROP TABLE IF EXISTS angajati;";
        return dropItLikeItsHot;
    }
    public String createQuerry(Element annotatedElement){
        String createTable = " CREATE TABLE `angajati` ( ";
        String newLine;
        String primaryKeyField= null;
        try {
            Class<?> entityClass = Class.forName(annotatedElement.toString());
            for(Field entityField : entityClass.getDeclaredFields()){
                switch (entityField.getType().toString()){
                    case ("class java.lang.String"):
                        newLine = "\n `" + entityField.getName() + "` varchar(60) DEFAULT NULL, ";
                        createTable +=newLine;
                        break;
                    case ("int"):
                        if(entityField.getName()!= "index"){
                            newLine = " \n `" + entityField.getName() + "` int(11) NOT NULL,";
                            createTable +=newLine;
                        }else{
                            primaryKeyField = entityField.getName();
                            newLine = " \n `" + entityField.getName() + "` int(11) NOT NULL AUTO_INCREMENT, ";
                            createTable +=newLine;
                        }
                        break;
                    case ("double"):
                        newLine = " \n `" + entityField.getName() + "` DECIMAL(10,2) DEFAULT NULL, ";
                        createTable +=newLine;
                        break;
                }

            }
            createTable +="\n PRIMARY KEY (`" + primaryKeyField +"`)\n " + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;";
            System.out.println(createTable);
            return createTable;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return createTable;
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement annotation : annotations){
            for(Element el: roundEnv.getElementsAnnotatedWith(annotation)){
                try {
                    Statement statement =  conn.createStatement();
                    statement.execute(dropTable());
                    Statement st2 = null;
                    st2= conn.createStatement();
                    boolean resultSet2 = statement.execute(createQuerry(el));
                    statement.close();
                    conn.close();
                    return resultSet2;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String []arguments = {"-proc:only","-processor","com.msg.examples.se.Day7.AnnotationProcessor","com.msg.examples.se.Day7.TestClass"};
        Main.main(arguments);

    }

}


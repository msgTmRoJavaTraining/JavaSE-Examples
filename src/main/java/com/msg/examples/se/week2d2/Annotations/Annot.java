package com.msg.examples.se.week2d2.Annotations;

import com.sun.tools.javac.Main;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static com.sun.activation.registries.LogSupport.log;


@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"com.msg.examples.se.week2d2.Annotations.*"})
public class Annot extends AbstractProcessor {
    public static void main(String[] args) throws Exception {
        String arguments[] = {"-proc:only", "-processor","com.msg.examples.se.week2d2.Annotations.Annot",
        "com.msg.examples.se.week2d2.Annotations.MyClass"};
        Main.main(arguments);
    }

    public Annot(){}

    public String generateTab(Element annotated) throws ClassNotFoundException {
        String querr="create table `angajati` (";
        String newLine;
        Class<?> entityClass =Class.forName(annotated.toString());
        for(Field field:entityClass.getDeclaredFields()){
            switch (field.getType().toString()){
                case ("class java.lang.String"):
                    newLine="\n `"+field.getName()+"`varchar(64) DEFAULT NULL,";
                    querr+=newLine;
                    break;
                case ("double"):
                    newLine="\n `"+field.getName()+"`decimal(10,2) DEFAULT NULL,";
                    querr+=newLine;
                    break;
                case ("int"):
                    newLine="\n `"+field.getName()+"`INT(10),";
                    querr+=newLine;
                    break;
            }
        }
        String finalLines = "\n  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;";

        querr += finalLines;
        System.out.println(querr);
        return querr;
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

            for(TypeElement annotation : annotations) {
                for (Element annotated : roundEnv.getElementsAnnotatedWith(annotation)) {
                    log("Found element " + annotated.getKind() + " annotated with " + annotation.getSimpleName() + ": " + annotated.getSimpleName());
                Statement statement = con.createStatement();
                statement.executeUpdate(generateTab(annotated));
                }
                }
            } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

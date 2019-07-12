package com.msg.examples.se.day5;

import java.sql.*;

public class JdbcExercitiul1 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        try (  Connection connection = DriverManager.getConnection(dbUrl, user, pass);
               Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("select * from employees;");

            if(resultSet.next()) {
                int count = resultSet.getMetaData().getColumnCount();

                for(int i = 1; i <= count; i++) {
                    System.out.println(resultSet.getMetaData().getColumnName(i) + " - " + resultSet.getMetaData().getColumnClassName(i));
                }
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.msg.examples.se.jdbc.Exercises;

import java.sql.*;

public class firstOne {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        int numberOfColumns;
        // 1. Get a connection to the database and create a statement
        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
             Statement statement = connection.createStatement()) {

            // 2. Execute SQL query
            ResultSet resultSet = statement.executeQuery("select * from employees");
            numberOfColumns=resultSet.getMetaData().getColumnCount();

            for (int i=1;i<numberOfColumns;i++)
                System.out.println(resultSet.getMetaData().getColumnName(i));

            resultSet.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}

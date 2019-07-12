package com.msg.examples.se.jdbc;

import java.sql.*;

public class getDetails {

    public static void main(String args[]) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        // 1. Get a connection to the database and create a statement
        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
             Statement statement = connection.createStatement()) {

            // 2. Execute SQL query
            ResultSet resultSet = statement.executeQuery("select * from employees");


            // 3. Process the result set
            while (resultSet.next()) {
                int count=resultSet.getMetaData().getColumnCount();

                for(int i=1;i<=count;i++){
                    System.out.println(resultSet.getMetaData().getColumnName(i));
                }
            }

            resultSet.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

}




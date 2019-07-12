package com.msg.examples.se.day5;

import java.sql.*;

public class JdbcExercitiul2 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        CallableStatement statement = null;

        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);){

            statement = connection.prepareCall("{call delete_employees_by_salary(?, ?)}");
            statement.setDouble(1, 100000.00);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();

            String deletedEmployees = statement.getString(2);
            System.out.println("Angajarii stersi sunt\n" + deletedEmployees);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

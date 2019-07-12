package com.msg.examples.se.jdbc;

import java.sql.*;

public class AnotherProcedure {

    public static void main(String args[]) {

        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;


        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";

        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);

            statement = connection.prepareCall("{call delete_employees_with_certain_salary(?, ?)}");
            statement.setDouble(1, 45000.0);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();

            String deleted = statement.getString(2);
            System.out.println("\n Am sters: " + deleted + "\n");

        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    }



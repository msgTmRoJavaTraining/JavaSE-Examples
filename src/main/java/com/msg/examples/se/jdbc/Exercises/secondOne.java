package com.msg.examples.se.jdbc.Exercises;

import java.sql.*;

public class secondOne {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;
        String deleted;

        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);

            // Call stored procedure get_count_for_department
            statement = connection.prepareCall("{call delete_emplyees_with_salary_bigger_than(?, ?)}");
            statement.setDouble(1, 50000);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();

            deleted = statement.getString(2);
            System.out.println(deleted);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}

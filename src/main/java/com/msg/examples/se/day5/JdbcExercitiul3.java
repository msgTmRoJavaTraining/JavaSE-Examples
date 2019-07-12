package com.msg.examples.se.day5;

import java.sql.*;

public class JdbcExercitiul3 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        CallableStatement statement = null;
        int numarTotal = 0;

        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass)){
            connection.setAutoCommit(false);

            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement2.executeQuery("select count(*) as total from employees;");

            if(resultSet.next()) {
                numarTotal = resultSet.getInt("total");
            }

            statement = connection.prepareCall("{call delete_employees_by_salary(?, ?)}");
            statement.setDouble(1, 100000.00);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();

            String deletedEmployees = statement.getString(2);

            String[] parts = null;
            try {
                parts = deletedEmployees.split(",");

                if(parts == null) {
                    throw new NullPointerException("Error?");
                }

                int numberOfDeletedRecords = parts.length;

                if (numberOfDeletedRecords > 35 * numarTotal / 100) {
                    connection.rollback();
                    System.out.println("Nu se pot sterge mai mult de 35% din angajati!");
                } else {
                    connection.commit();
                    System.out.println("Angajarii stersi sunt\n" + deletedEmployees);
                }
            } catch (NullPointerException e) {
                System.out.println("Nu s-au gasit angajati cu acest salariu!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

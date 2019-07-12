package com.msg.examples.se.jdbc;

import java.io.*;
import java.sql.*;

public class JDBCClobOperations {
    public static void main(String args[]) {
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root", pass = "root";
        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass)) {
            // Write CLOB to database
            String sql = "update employees set resume_clob=? where email='john.doe@foo.com'";
            PreparedStatement updateStatement = connection.prepareStatement(sql);

            File theFile = new File(".\\src\\main\\resources\\resume_from_db.txt");
            FileReader updateInput = new FileReader(theFile);
            updateStatement.setCharacterStream(1, updateInput);

            updateStatement.executeUpdate();

            // Read CLOB from database
            Statement selectStatement = connection.createStatement();
            sql = "select resume_clob from employees where email='john.doe@foo.com'";
            ResultSet result = selectStatement.executeQuery(sql);

            if (result.next()) {
                theFile = new File(".\\src\\main\\resources\\resume_from_db.txt");
                FileWriter output = new FileWriter(theFile);

                Reader selectInput = result.getCharacterStream("resume_clob");
                int theChar;
                while ((theChar = selectInput.read()) > 0) {
                    output.write(theChar);
                }
                output.flush();

                System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
            }
        } catch (SQLException | IOException exc) {
            exc.printStackTrace();
        }
    }
}

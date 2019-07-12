package com.msg.examples.se.Day5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        exercise1();
        int indexCol = 1;
        int givenAmount = 80000;
        String namesResulted;
        List<String> deletedEmployees= new ArrayList<>();
        String dbUrl = "jdbc:mysql://localhost:3306/java_training?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";
        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from employees");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                System.out.println("Lines cover the following columns: ");
                while(indexCol<resultSetMetaData.getColumnCount()){
                    System.out.println(resultSetMetaData.getColumnName(indexCol));
                    indexCol +=1;
                }
            resultSet.close();
            CallableStatement st = null;
            st = connection.prepareCall("{call delete_employees_with_higher_salary(?, ?)}");
            st.setInt(1,givenAmount);
            st.registerOutParameter(2, Types.VARCHAR);
            st.execute();
            namesResulted = st.getString(2);
            if(namesResulted!= null && namesResulted.contains(",")){
                deletedEmployees =  Arrays.asList(namesResulted.split(","));
                System.out.println("\nDeleted employees are: ");
            }
            if(deletedEmployees.size()>0){
                for(String emp: deletedEmployees){
                    System.out.println(emp);
                }
            }else if(namesResulted != null){
                System.out.println(namesResulted);
            }



        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }

    public static void exercise1() throws Exception {
        List<Employee> employeeList1 = new ArrayList<>();
        List<Employee> employeeList2 = new ArrayList<>();
        List<Employee> employeeList3 = new ArrayList<>();
        List<Department> departmentsList1 = new ArrayList<>();
        List<Department> departmentsList2 = new ArrayList<>();
        List<Restaurant> restaurants = new ArrayList<>();
        Employee emp1 = new Employee(1, "emp1", 1234);
        Employee emp2 = new Employee(2, "emp2", 1532);
        Employee emp3 = new Employee(3, "emp3", 1122);
        Employee emp4 = new Employee(1, "emp4", 1453);
        Employee emp5 = new Employee(2, "emp5", 5532);
        Employee emp6 = new Employee(3, "emp6", 3532);
        Employee emp7 = new Employee(1, "emp7", 5644);
        Employee emp8 = new Employee(2, "emp8", 7545);
        Employee emp9 = new Employee(3, "emp9", 7554);
        Employee manager1 = new Employee(98, "Manager1", 57423);
        Employee manager2 = new Employee(97, "Manager2", 86443);

        employeeList1.add(emp1);
        employeeList1.add(emp2);
        employeeList1.add(emp3);

        employeeList2.add(emp4);
        employeeList2.add(emp5);
        employeeList2.add(emp6);

        employeeList3.add(emp7);
        employeeList3.add(emp8);
        employeeList3.add(emp9);

        Department d1 = new Department(01, "department1");
        Department d2 = new Department(02, "department2");
        Department d3 = new Department(03, "department3");
        d1.setEmployees(employeeList1);
        d2.setEmployees(employeeList2);
        d3.setEmployees(employeeList3);
        departmentsList1.add(d1);
        departmentsList1.add(d2);
        departmentsList2.add(d3);
        Restaurant r1 = new Restaurant(111, "city1", manager1);
        Restaurant r2 = new Restaurant(222, "city2", manager2);
        r1.setDepartments(departmentsList1);
        r2.setDepartments(departmentsList2);
        restaurants.add(r1);
        restaurants.add(r2);

        FranchiseNetwork fn = new FranchiseNetwork();
        fn.setRestaurants(restaurants);

        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        marshaller.marshal(fn, new File("franchise_output.xml"));
        marshaller.marshal(fn, outputStream);
        Unmarshaller um = context.createUnmarshaller();
        FranchiseNetwork franchiseUnmarshalled = (FranchiseNetwork) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(franchiseUnmarshalled);
    }

}

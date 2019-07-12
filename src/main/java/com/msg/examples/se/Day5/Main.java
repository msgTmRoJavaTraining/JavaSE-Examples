package com.msg.examples.se.Day5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        exercise1();
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

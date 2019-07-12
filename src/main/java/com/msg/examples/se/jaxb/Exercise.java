package com.msg.examples.se.jaxb;

import com.msg.examples.se.jaxb.entities.Department;
import com.msg.examples.se.jaxb.entities.Employee;
import com.msg.examples.se.jaxb.entities.FranchiseNetwork;
import com.msg.examples.se.jaxb.entities.Restaurant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class Exercise {
    public static void main(String[] args) throws JAXBException {
        Employee employee1 = new Employee(1, "Ionescu", 1250);
        Employee employee2 = new Employee(2, "Popescu", 1550);
        Employee employee3 = new Employee(3, "Calinescu", 1250);
        Employee employee4 = new Employee(4, "Ionescu", 1250);
        Employee employee5 = new Employee(5, "Basescu", 1250);
        Employee employee6 = new Employee(6, "Mihaescu", 1250);
        Employee employee7 = new Employee(7, "Iliescu", 1250);
        Employee employee8 = new Employee(8, "Scarlatescu", 1250);


        Department department1 = new Department(1, "Pizza");
        department1.getEmployeeList().add(employee1);
        department1.getEmployeeList().add(employee2);

        Department department2 = new Department(1, "Paste");
        department2.getEmployeeList().add(employee3);
        department2.getEmployeeList().add(employee4);

        Department department3 = new Department(1, "Supe");
        department3.getEmployeeList().add(employee5);
        department3.getEmployeeList().add(employee6);

        Department department4 = new Department(1, "Curatenie");
        department4.getEmployeeList().add(employee7);
        department4.getEmployeeList().add(employee8);

        Restaurant restaurant1 = new Restaurant(1, "Timisoara", employee1);
        restaurant1.getDepartmentList().add(department1);
        restaurant1.getDepartmentList().add(department2);

        Restaurant restaurant2 = new Restaurant(2, "Bucuresti", employee2);
        restaurant2.getDepartmentList().add(department3);
        restaurant2.getDepartmentList().add(department4);

        FranchiseNetwork franchise = new FranchiseNetwork();
        franchise.getRestaurantList().add(restaurant1);
        franchise.getRestaurantList().add(restaurant2);

        // Marshalling
        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(franchise, new File("outputFranchises.xml"));

        // Unmarshalling
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        marshaller.marshal(franchise, outputStream);
        marshaller.marshal(franchise, new File("outputFranchises.xml"));
        Unmarshaller um = context.createUnmarshaller();
        FranchiseNetwork franchiseNetworkUnmarshalled = (FranchiseNetwork) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(franchiseNetworkUnmarshalled);
    }
}

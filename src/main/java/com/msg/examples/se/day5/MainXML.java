package com.msg.examples.se.day5;

import com.msg.examples.se.jaxb.entities.Dogstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainXML {
    public static void main(String[] args) throws JAXBException {
        //Exerctitiile pentru Day 5 - XML
        executeTasks();
    }

    private static void executeTasks() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //2 restaurante, fiecare cu 2 departamente(cleaners si cooks) si 4 angajati, plus un general manager
        List<Employee> cleanersRestaurant1 = new ArrayList<>();
        cleanersRestaurant1.add(new Employee(1, "Popescu Dan", 1800.00));
        cleanersRestaurant1.add(new Employee(2, "Stan Flavia", 1800.00));

        List<Employee> cooksRestaurant1 = new ArrayList<>();
        cooksRestaurant1.add(new Employee(3, "Popa Silvia", 3400.00));
        cooksRestaurant1.add(new Employee(4, "Stan Flavia", 3400.00));

        List<Employee> cleanersRestaurant2 = new ArrayList<>();
        cleanersRestaurant2.add(new Employee(1, "Pop Anca", 1700.00));
        cleanersRestaurant2.add(new Employee(2, "Muresan Daniel", 1700.00));

        List<Employee> cooksRestaurant2 = new ArrayList<>();
        cooksRestaurant2.add(new Employee(3, "Dunca Marius", 3200.00));
        cooksRestaurant2.add(new Employee(4, "Stanciu Rebeca", 3200.00));

        // *** Departamente ***
        List<Departament> departamentsRestaurant1 = new ArrayList<>();
        departamentsRestaurant1.add(new Departament(1, "Cleaners", cleanersRestaurant1));
        departamentsRestaurant1.add(new Departament(2, "Cooks", cooksRestaurant1));

        List<Departament> departamentsRestaurant2 = new ArrayList<>();
        departamentsRestaurant2.add(new Departament(1, "Cleaners", cleanersRestaurant2));
        departamentsRestaurant2.add(new Departament(2, "Cooks", cooksRestaurant2));

        // *** GeneralManagers ***
        Employee generalManager1 = new Employee(5, "Crisan Alin", 4700.00);
        Employee generalManager2 = new Employee(5, "Burcea Raluca", 4700.00);

        // *** Restaurante ***
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "Timisoara", generalManager1, departamentsRestaurant1));
        restaurants.add(new Restaurant(2, "Arad", generalManager2, departamentsRestaurant2));

        // *** Franghise ***
        FranchiseNetwork franchiseNetwork = new FranchiseNetwork(restaurants);

        // *** Transformarea in format XML
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(franchiseNetwork, outputStream);
        marshaller.marshal(franchiseNetwork, new File("franchise_output.xml"));

        // *** Transformarea din XML in Java
        Unmarshaller unmarshaller = context.createUnmarshaller();
        FranchiseNetwork franchiseNetworkUnmarshalled = (FranchiseNetwork) unmarshaller.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(franchiseNetworkUnmarshalled);
    }
}

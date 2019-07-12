package com.msg.examples.se.dayFive;

import com.msg.examples.se.jaxb.entities.Dog;
import com.sun.jmx.remote.internal.ArrayQueue;

import javax.crypto.spec.DESedeKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainJAXB {


    public static void main(String[] args) throws Exception {

        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        Employee generalManager1=new Employee(1,"Ana",1000.0);
        Employee generalManager2=new Employee(2,"Ion",1500.0);


        List<Employee> employees1=new ArrayList<>();
        Employee e1=new Employee(1,"Larisa",2000.0);
        Employee e2=new Employee(2,"Roxana",1000.0);

        List<Employee> employees2=new ArrayList<>();
        Employee e3=new Employee(3,"Ale",3000.0);
        Employee e4=new Employee(4,"Maria",1500.0);

        employees1.add(e1);
        employees1.add(e2);
        employees2.add(e3);
        employees2.add(e4);


        List<Department> departments1=new ArrayList<>();
        Department d1 = new Department(1,"Cleaners", employees1);

        List<Department> departments2=new ArrayList<>();
        Department d2 = new Department(2,"Cookers", employees2);

        departments1.add(d1);
        departments2.add(d2);



        List<Restaurant> restaurants=new ArrayList<>();
        Restaurant r1 = new Restaurant(1,"Timisoara",generalManager1,departments1);
        Restaurant r2 = new Restaurant(2,"Bucuresti",generalManager2,departments2);

        restaurants.add(r1);
        restaurants.add(r2);


        FranchiseNetwork franchise=new FranchiseNetwork();
        franchise.addRest(r1);
        franchise.addRest(r2);



        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        marshaller.marshal(franchise, outputStream);
        marshaller.marshal(franchise, System.out);
        marshaller.marshal(franchise, new File("output.xml"));

        Unmarshaller unmarshaller = context.createUnmarshaller();
       FranchiseNetwork franchiseNetworkUnmarshaller = (FranchiseNetwork) unmarshaller.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));





    }


}

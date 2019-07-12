package com.msg.examples.se.jaxb.entities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args) throws Exception {

        franchise();

     }

    public static void franchise() throws Exception
    {
        Employee employee1=new Employee(1,"Angajat1",100);
        Employee employee2=new Employee(1,"Angajat2",200);
        Employee employee3=new Employee(1,"Angajat3",300);
        Employee employee4=new Employee(1,"Angajat4",400);
        Employee employee5=new Employee(1,"Angajat5",500);
        Employee employee6=new Employee(1,"Angajat6",600);
        Employee employee7=new Employee(1,"Angajat7",700);
        Employee employee8=new Employee(1,"Angajat8",800);

        ArrayList<Employee> e1=new ArrayList<>();
        ArrayList<Employee> e2=new ArrayList<>();
        ArrayList<Employee> e3=new ArrayList<>();
        ArrayList<Employee> e4=new ArrayList<>();

        e1.add(employee1);
        e1.add(employee2);

        e2.add(employee3);
        e2.add(employee4);

        e3.add(employee5);
        e3.add(employee6);

        e4.add(employee7);
        e4.add(employee8);

        Department d1=new Department(2,"Dep1",e1);
        Department d2=new Department(2,"Dep2",e2);
        Department d3=new Department(2,"Dep3",e3);
        Department d4=new Department(2,"Dep4",e4);


        ArrayList<Department> dep1=new ArrayList<>();
        ArrayList<Department> dep2=new ArrayList<>();

        dep1.add(d1);
        dep1.add(d2);
        dep2.add(d3);
        dep2.add(d4);


        Restaurant r1=new Restaurant(3,"Arad",employee1,dep1);
        Restaurant r2=new Restaurant(3,"Timisoara",employee7,dep2);

        ArrayList<Restaurant> res=new ArrayList<>();

        res.add(r1);
        res.add(r2);


        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        FranchiseNetwork fn=new FranchiseNetwork(res);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(fn, outputStream);
        marshaller.marshal(fn, System.out);


        Unmarshaller unmarshaller = context.createUnmarshaller();
        FranchiseNetwork franchiseNetworkUnmarshalled = (FranchiseNetwork) unmarshaller.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));

        System.out.println();

        franchiseNetworkUnmarshalled.getRestaurants().forEach(System.out::println);
    }
}

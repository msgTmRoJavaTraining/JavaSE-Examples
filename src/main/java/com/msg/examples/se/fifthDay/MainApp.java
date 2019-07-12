package com.msg.examples.se.fifthDay;


import com.msg.examples.se.jaxb.entities.Dog;
import com.msg.examples.se.jaxb.entities.Dogstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainApp {
    private static void thaFunction() throws Exception {
        FranchiseNetwork frNet=new FranchiseNetwork();
        Restaurant res1=new Restaurant("res1","Romania");
        Employee mngr=new Employee("0000","BillyBob",825.2);//MANAGER
        Departament dep1=new Departament("dep1","HR");           //DEPARTAMENT
        Employee em1=new Employee("0001","greg",125.2);//EMPLOYEE
        Employee em2=new Employee("0002","dave",225.2);//EMPLOYEE
        Employee em3=new Employee("0003","steve",325.2);//EMPLOYEE
        dep1.getEmployees().add(em1);//
        dep1.getEmployees().add(em2);//add employees to departament
        dep1.getEmployees().add(em3);//
        res1.getDepartaments().add(dep1);//add departament to restaurant
        res1.setManager(mngr);//add manager to restaurant

        frNet.getRestaurants().add(res1);//add restaurant


        JAXBContext context = JAXBContext.newInstance(FranchiseNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(frNet, outputStream);
        marshaller.marshal(frNet, new File("Franchises.xml"));

        Unmarshaller um = context.createUnmarshaller();
        FranchiseNetwork francUnmarshalled = (FranchiseNetwork) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(francUnmarshalled);


//        marshaller.marshal(frNet, outputStream);
//        marshaller.marshal(frNet, System.out);
//        marshaller.marshal(frNet, new File("Franchises.xml"));
//
//
//        Unmarshaller um = context.createUnmarshaller();
//        FranchiseNetwork francUnmarshalled = (FranchiseNetwork) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
//        System.out.println(francUnmarshalled);
    }
    public static void main(String args[])throws Exception{
        //try {
            thaFunction();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}

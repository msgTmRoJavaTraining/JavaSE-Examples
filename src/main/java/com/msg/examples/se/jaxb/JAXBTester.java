package com.msg.examples.se.jaxb;

import com.msg.examples.se.jaxb.entities.Dog;
import com.msg.examples.se.jaxb.entities.Dogstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class JAXBTester {
    public static void main(String[] args) throws Exception {
      //  example1();
        example2();
    }

    private static void example1() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Dog bobbyDog = new Dog(1, "Bobby", "Terrier");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        marshaller.marshal(bobbyDog, outputStream);
        marshaller.marshal(bobbyDog, System.out);
        marshaller.marshal(bobbyDog, new File("output.xml"));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Dog dogUnmarshalled = (Dog) unmarshaller.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(dogUnmarshalled.getName());
    }

    private static void example2() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Dogstore.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Dog bobbyDog = new Dog(1, "Bobby", "Terrier");
        Dog lilyDog = new Dog(2, "Lily", "Golden Retriever");
        Dogstore dogstore = new Dogstore(1, "Andrew's dog store");
        dogstore.getDogs().add(bobbyDog);
        dogstore.getDogs().add(lilyDog);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Write to System.out
        marshaller.marshal(dogstore, outputStream);
        marshaller.marshal(dogstore, new File("dogstore_output.xml"));
        Unmarshaller um = context.createUnmarshaller();
        Dogstore dogstoreUnmarshalled = (Dogstore) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(dogstoreUnmarshalled);
    }
}

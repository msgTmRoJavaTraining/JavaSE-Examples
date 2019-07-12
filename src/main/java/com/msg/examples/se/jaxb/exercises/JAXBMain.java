package com.msg.examples.se.jaxb.exercises;

import lombok.ToString;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@ToString
@XmlRootElement(name = "FranciseNetwork")
class FranciseNetwork {

    private List<Restaurant> myList = new ArrayList<>();

    public void add(Restaurant rest) {

        myList.add(rest);
    }
    @XmlElementWrapper(name = "Restaurant")
    public List<Restaurant> getRestaurants() {

        return myList;
    }
}
//sasa
@ToString
class Restaurant {

    private int id;
    private String adress;
    private Employee generalManager;
    private List<Department> departments;

    public Restaurant(int id, String adress, Employee generalManager, List<Department> departmants) {
        this.id = id;
        this.adress = adress;
        this.generalManager = generalManager;
        this.departments = departmants;
    }

    @XmlElement(name = "restaurant_id")
    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public Employee getGeneralManager() {
        return generalManager;
    }

    @XmlElementWrapper(name = "department_restaurant")
    public List<Department> getDepartments() {
        return departments;
    }
}

@ToString
class Department {

    private int id;
    private String name;
    private List<Employee> employees;


    public Department(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    @XmlElement(name = "department_id")
    public int getId() {
        return id;
    }

    @XmlElement(name = "department_name")
    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

@ToString
class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @XmlElement(name = "employee_id")
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class JAXBMain {

    private static void example() throws Exception {

        JAXBContext context = JAXBContext.newInstance(FranciseNetwork.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        FranciseNetwork myFrancise = new FranciseNetwork();
        Employee emp1 = new Employee(1, "Ion", 2000);
        Employee emp2 = new Employee(2, "Andrei", 3000);
        Employee emp3 = new Employee(2, "Alin", 6000);


        List<Employee> list1 = new ArrayList<>();
        list1.add(emp1);
        list1.add(emp2);

        Department department1 = new Department(1000, "IT", list1);
        Department department2 = new Department(3000, "Finance", list1);
        Department department3 = new Department(5000, "HR", list1);
        Department department4 = new Department(10000, "Administration", list1);

        List<Department> listDep1 = new ArrayList<>();
        List<Department> listDep2 = new ArrayList<>();
        listDep1.add(department1);
        listDep1.add(department2);
        listDep2.add(department3);
        listDep2.add(department4);

        Restaurant restaurant1 = new Restaurant(11, "Timisoara", emp3, listDep1);
        Restaurant restaurant2 = new Restaurant(12, "Bucuresti", emp3, listDep2);


        myFrancise.add(restaurant1);
        myFrancise.add(restaurant2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        m.marshal(myFrancise, outputStream);
        m.marshal(myFrancise, System.out);
        m.marshal(myFrancise,new File("output1.xml"));


    }

    public static void main(String[] args) throws Exception {
        example();

    }
}

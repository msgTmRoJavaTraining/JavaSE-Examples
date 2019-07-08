package com.msg.examples.se.inheritance;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Le BoSS", 1000000, 1999, 12, 1);
        manager.setBonus(100);

        Person[] staff = new Person[6];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        staff[3] = new Student("Astanei Andrei", "Facultatea de Automatica si Calculatoare");

        Manager manager1 = new Manager("Boss 2", 2000000, 1990, 11, 19);
        Manager manager2 = new Manager("Boss 2", 2000000, 1990, 11, 19);
        manager1.setBonus(170);
        manager2.setBonus(170);

        staff[4] = manager1;
        staff[5] = manager2;

        for (Person e : staff) {
            if(e instanceof Employee) {
                System.out.println(e.getName() + " " + ((Employee) e).getSalary() + " lei");
            }

            if(e instanceof Student) {
                System.out.println(e.getName() + " " + ((Student) e).getFacultate());
            }
        }

        //manager = staff[0]; //compile time error - every manager is an employee but the opposite is not true, thus prohibited
        if(staff[1] instanceof Manager) {
            manager = (Manager) staff[1];
            manager.setBonus(123);
            System.out.println(manager.getSalary());
        } else {
            System.out.println("NO NO - not a manager");
        }

        // raise everyone's salary by 5%
        for (Person e : staff) {
            if(e instanceof Employee) {
                ((Employee) e).raiseSalary(5);
            }
        }

        // print out information about all Employee objects
        System.out.println("\nSalariile angajatilor dupa marirea cu 5%:");
        for (Person e : staff) {
            if(e instanceof Employee) {
                System.out.println("name = " + e.getName() + ", salary = " + ((Employee) e).getSalary());
            }

        }

        //------------------------casts------------------
//        Manager m = (Manager) staff[1];
//        System.out.println(m.getSalary()); // runtime error: ClassCastException - use instanceof

        //------------------------hashcode------------------
        System.out.println("\nAfisare informatii despre toate persoanele:");
        System.out.println(staff);
        for (Person e : staff) {
            System.out.println(e);
        }

        System.out.println("\nEste egal Le BoSS si Boss2?");
        if(manager.equals(staff[4])) {
            System.out.println("Sunt egali");
        } else {
            System.out.println("Nu sunt egali");
        }

        System.out.println("\nDar Boss 2 si Boss 3?");
        if(staff[4].equals(staff[5])) {
            System.out.println("Sunt egali");
        } else {
            System.out.println("Nu sunt egali");
        }

        System.out.println("\nInvitam persoanele la dans:");
        for (Person e : staff) {
            e.dance();
        }
    }
}

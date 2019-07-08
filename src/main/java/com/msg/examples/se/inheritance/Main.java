package com.msg.examples.se.inheritance;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Le Bo$$", 1000000, 1999, 12, 1);
        manager.setBonus(100);

        Employee[] staff = new Employee[3];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker",true, 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", false,40000, 1990, 3, 15);

        for (Employee e : staff) {
//           System.out.println(e.getName() + " " + e.getSalary());
        }

       // manager = staff[0]; //compile time error - every manager is an employee but the opposite is not true, thus prohibited
        if(staff[1] instanceof Manager) {
            manager = (Manager) staff[1];
            manager.setBonus(123);
            System.out.println(manager.getSalary());
        } else {
            System.out.println("NONO");
        }
        // raise everyone's salary by 5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }

        //------------------------casts------------------
       // Manager m = (Manager) staff[1];
        //System.out.println(m.getSalary()); // runtime error: ClassCastException - use instanceof

        //------------------------hashcode------------------
        System.out.println(staff);
        for (Employee e : staff) {
            System.out.println(e);
        }


       // System.out.println(staff[0]);
        //staff[0].dance();

        Student s1=new Student("Andrei");
        s1.dance();

        for (Employee e: staff)
            e.dance();


        Manager m1=new Manager("Andrei",5000,1998,12,18);
        Manager m2=new Manager("Andrei",5000,1998,12,8);

        System.out.println(m1.equals(m2));

        System.out.println(staff[0]);
    }
}

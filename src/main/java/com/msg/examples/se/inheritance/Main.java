package com.msg.examples.se.inheritance;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Le Bo$$", 1000000, 1999, 12, 1,true);
        manager.setBonus(100);

        Employee[] staff = new Employee[3];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1,true);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15,false);

        Manager mng1=new Manager("mihai",2500,1980,6,5,true);
        Manager mng2=new Manager("mihai",2500,1980,6,5,true);

        //Simple test to prove the working of "equals" method
        if(mng1.equals(mng2))
            System.out.println("EGALE");
        else System.out.println("DIFERITE");

        for (Employee e : staff) {
//            System.out.println(e.getName() + " " + e.getSalary());
        }

//        manager = staff[0]; //compile time error - every manager is an employee but the opposite is not true, thus prohibited
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
//        Manager m = (Manager) staff[1];
//        System.out.println(m.getSalary()); // runtime error: ClassCastException - use instanceof

        //------------------------hashcode------------------
        System.out.println(staff);
        for (Employee e : staff) {
            System.out.println(e);
        }

    }
}

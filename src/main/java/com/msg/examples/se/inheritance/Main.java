package com.msg.examples.se.inheritance;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class Main {
    public static void main(String[] args) {
        Student stud= new Student("Mihai",20, "UVT", "Info");
        Manager manager = new Manager("Le Bo$$", 34 ,1000000, 1999, 12, 1);
        Manager manager2 = new Manager("Le Bo$$", 34 ,1000000, 1999, 12, 1);
        manager.setBonus(100);
        manager2.setBonus(100);

        Employee[] staff = new Employee[4];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker", 23, 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester",25, 40000, 1990, 3, 15);
        staff[3] = manager2;

        for (Employee e : staff) {
//            System.out.println(e.getName() + " " + e.getSalary());
        }

//        manager = staff[0]; //compile time error - every manager is an employee but the opposite is not true, thus prohibited
        if(staff[1] instanceof Manager) {
            manager = (Manager) staff[1];
            manager.setBonus(123);
            manager.dance();
            System.out.println(manager.getSalary());
        } else {
            staff[1].dance();
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
        //System.out.println(staff);
        for (Employee e : staff) {
            System.out.println(e);
        }
        System.out.println(stud);
        stud.dance();
        if(manager.equals(manager2)){
            System.out.println("Same manager!");
        }
        else{
            System.out.println("They are not the same managers!");
        }
        System.out.println(manager);
        manager.dance();

    }
}

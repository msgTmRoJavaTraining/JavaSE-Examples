package com.msg.examples.se.inheritance;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Le Bo$$", 1000000, 1999, 12, 1);
        manager.setBonus(100);

        Person[] staff = new Person[6];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        staff[3] = new Student( "Larisa ");
        staff[4] = new Manager("Ana ",20000,1997,7,20);
        staff[5] = new Manager("Ana ",20000,1997,7,20);
//        staff[4].setBonus(100);
//        staff[5].setBonus(100);

        staff[0].dance();
        staff[1].dance();
        staff[3].dance();




        for (Person e : staff) {
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


         //raise everyone's salary by 5%
//        for (Person e : staff) {
//            if(e instanceof Manager) {
//                e.raiseSalary(5);
//            }
//        }

        // print out information about all Employee objects
//        for (Person e : staff) {
//            if(e instanceof Manager)
//            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
//        }

        //------------------------casts------------------
//        Manager m = (Manager) staff[1];
//        System.out.println(m.getSalary()); // runtime error: ClassCastException - use instanceof

        //------------------------hashcode------------------
        System.out.println(staff);
        for (Person e : staff) {
            System.out.println(e);
        }
        Manager manager1 = new Manager("Ana ",20000,1997,7,20);
        Manager manager2 = new Manager("Ana ",20000,1997,7,20);

        if(manager1.equals(manager2)) {
            System.out.println("Sunt egali");
        }
            else{
                System.out.println("Nu sunt egali");
        }

    }
}

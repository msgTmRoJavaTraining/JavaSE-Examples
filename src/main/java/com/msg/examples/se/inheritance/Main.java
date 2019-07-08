package com.msg.examples.se.inheritance;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Le Bo$$", 1000000, 1999, 12, 1);
        Manager managerCopy = new Manager("Le Bo$$", 1000000, 1999, 12, 1);
        Manager managerImpostor = new Manager("Za true Le Bo$$", 1000000, 1999, 12, 1);



        manager.setBonus(100);

/*
        Employee[] staff = new Employee[3];

        staff[0] = manager;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

 */
/*
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
*/

    Person[] people=new Person[5];
    people[0]=manager;
    people[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
    people[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
    people[3]= new Student("Bob","schl1");
    people[4]= new Student("Joe","schl2");
        for (Person e : people) {

            if(e instanceof Student)
            {
                System.out.println(e.getName()+" " +((Student) e).getSchool());
            }
            else if(e instanceof Manager)
            {
                System.out.println(e);
            }
            else if(e instanceof Employee)
            System.out.println(e.getName() + " " + ((Employee) e).getSalary());
            e.dance();
        }

        System.out.println(manager);
        System.out.println( "Copy "+ manager.equals(managerCopy));
        System.out.println("Impostor "+ manager.equals(managerImpostor));
    }
}

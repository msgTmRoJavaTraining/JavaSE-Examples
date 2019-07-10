package com.msg.examples.se.interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static final String NEW_PARAGRAPH_JUMP = "\n---------------------------\n";

    public static void main(String[] args) {

        // COMPARABLE / COMPARATOR / LAMBDA EXPRESSIONS / ANONYMOUS CLASSES
        System.out.println("  --- COMPARABLE / COMPARATOR / LAMBDA EXPRESSIONS / ANONYMOUS CLASSES ---\n");

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 3, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 12, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 10, 15);

        Employee[] staff1 = Arrays.copyOf(staff, staff.length);
        Employee[] staff2 = Arrays.copyOf(staff, staff.length);
        Employee[] staff3 = Arrays.copyOf(staff, staff.length);

        // Method one: using Comparable on the Employee class and overriding the compareTo method
        System.out.println("Ascending by salary using the Comparable interface:\n");
        Arrays.sort(staff);
        //printEmployeeArray(staff);
        printEmployeeArray(staff);

        System.out.println(NEW_PARAGRAPH_JUMP);

        // Method two: Comparator object created by implementing the Comparator interface
        EmployeeComparator employeeComparator = new EmployeeComparator();

        System.out.println("Descending by salary using the Comparator interface:\n");
        Arrays.sort(staff1, employeeComparator);
        printEmployeeArray(staff1);

        System.out.println(NEW_PARAGRAPH_JUMP);

        // Method three: Comparator object created by using a Lambda Expression and implicitly an Anonymous Function
        Comparator<Employee> employeeComparatorWithLambdaExpression =
                (employee1, employee2) ->
                        Double.compare(employee2.getHireDay().getYear(), employee1.getHireDay().getYear());

        System.out.println("Descending by year of hire using a Lambda Expression created Comparator object:\n");
        Arrays.sort(staff2, employeeComparatorWithLambdaExpression);
        printEmployeeArray(staff2);

        System.out.println(NEW_PARAGRAPH_JUMP);

        // Method four: Comparator object created by using an Anonymous Class
        Comparator<Employee> employeeComparatorWithAnnonymousClass = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return Double.compare(employee1.getHireDay().getMonth().getValue(), employee2.getHireDay().getMonth().getValue());
            }
        };

        System.out.println("Ascending by month of hire using an Anonymous Class created Comparator object:\n");
        Arrays.sort(staff3, employeeComparatorWithAnnonymousClass);
        printEmployeeArray(staff3);

        System.out.println(NEW_PARAGRAPH_JUMP);


        // STREAMS
        System.out.println("\n  --- STREAMS ---\n");

        Predicate<Double> checkGreaterThan5000 = salary -> salary >= 50000;
        List<Employee> employees = Arrays.asList(staff);
        employees.stream().map(emp -> emp.getSalary()).filter(checkGreaterThan5000).forEach(System.out::println);
        System.out.println();

        employees.stream().map(Employee::getSalary).filter(salary -> salary > 70000).forEach(System.out::println);
        System.out.println();

    }

    private static void printEmployeeArray(Employee[] employees) {
        // print out information about all Employee objects
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}

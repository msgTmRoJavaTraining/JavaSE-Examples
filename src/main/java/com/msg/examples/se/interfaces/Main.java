package com.msg.examples.se.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 3, 15);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 10, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 12, 1);

        //ascending order
        Arrays.sort(staff);
        //printEmployeeArray(staff);

        System.out.println("---------------------------");

        EmployeeComparator employeeComparator = new EmployeeComparator();

        Comparator<Employee> employeeComparatorWithLambdaExpression =
                ( employee1,  employee2) ->
                        Double.compare(employee2.getHireDay().getYear(), employee1.getHireDay().getYear());

        Comparator<Employee> employeeComparatorWithAnnonymousClass = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return Double.compare(employee1.getHireDay().getMonth().getValue(), employee2.getHireDay().getMonth().getValue());
            }
        };

        //descending order
        System.out.println("employeeComparator: ");
        Arrays.sort(staff, employeeComparator);
        printEmployeeArray(staff);
        System.out.println();

        Employee[] staff2 = Arrays.copyOf(staff, staff.length);

        System.out.println("employeeComparatorWithLambdaExpression: ");
        Arrays.sort(staff2, employeeComparatorWithLambdaExpression);
        printEmployeeArray(staff2);
        System.out.println();

        Employee[] staff3 = Arrays.copyOf(staff, staff.length);

        System.out.println("employeeComparatorWithAnnonymousClass");
        Arrays.sort(staff3, employeeComparatorWithAnnonymousClass);
        printEmployeeArray(staff3);
        System.out.println();

        Predicate<Double> checkGreaterThan5000 = salary -> salary >= 50000;
        List<Employee> employees = Arrays.asList(staff);
        employees.stream().map(emp -> emp.getSalary()).filter(checkGreaterThan5000).forEach(System.out::println);
        System.out.println();

        employees.stream().map(Employee::getSalary).filter(salary -> salary > 70000).forEach(System.out::println);
        System.out.println();

        printEmployeeArray(staff);

    }

    private static void printEmployeeArray(Employee[] employees) {
        // print out information about all Employee objects
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

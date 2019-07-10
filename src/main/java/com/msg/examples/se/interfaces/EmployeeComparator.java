package com.msg.examples.se.interfaces;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Double.compare(employee2.getSalary(), employee1.getSalary());
    }
}

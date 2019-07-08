package com.msg.examples.se.inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person{

    private double salary;
    private LocalDate hireDay;
    private boolean alcohol;

    public Employee(String n, double s, int year, int month, int day,boolean alc) {
        name = n;
        this.alcohol=alc;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject) {
        Employee other = (Employee) otherObject;
        // test whether the fields have identical values
        return super.equals(otherObject)
                && salary == other.salary
                && hireDay.equals(other.hireDay);
    }

    public int hashCode() {
        return 7 * Objects.hashCode(name)
                + 11 * Double.hashCode(salary)
                + 13 * Objects.hashCode(hireDay);
    }

    @Override
    public void dance() {
        if(alcohol)
            System.out.println("I can dance only if I'm drunk!");
    }
}

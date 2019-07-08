package com.msg.examples.se.inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person{

    protected double salary;
    protected LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        super(n);
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }


    public void dance(){
        System.out.println("Employees only dance when alcohol is available");
    }



    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String toString(){
        return "Name: "+ getName() + "Salary" + getSalary()+ "Hire Day: " + getHireDay();
    }


    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;
        // now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;
        // test whether the fields have identical values
        return name.equals(other.name)
                && salary == other.salary
                && hireDay.equals(other.hireDay);
    }

    public int hashCode() {
        return 7 * Objects.hashCode(name)
                + 11 * Double.hashCode(salary)
                + 13 * Objects.hashCode(hireDay);
    }
}

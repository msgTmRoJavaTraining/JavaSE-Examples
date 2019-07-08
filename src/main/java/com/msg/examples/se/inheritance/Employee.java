package com.msg.examples.se.inheritance;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person{

    private boolean alcohol;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, boolean a,double s, int year, int month, int day) {

        super(n);
        this.alcohol=a;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

  //  public String getName() {
   //     return name;
   // }

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
        return getName().equals(other.getName())
                && salary == other.salary
                && hireDay.equals(other.hireDay);
    }

    public int hashCode() {
        return 7 * Objects.hashCode(getName())
                + 11 * Double.hashCode(salary)
                + 13 * Objects.hashCode(hireDay);
    }

    @Override
    public void dance() {
        if(this.alcohol)
            System.out.println("Dancing");
        else
            System.out.println("Not dancing");
    }

    public String toString()
    {
        return "name = " + this.getName() + ", salary = " + this.getSalary() + " - "+this.getHireDay();
    }
}

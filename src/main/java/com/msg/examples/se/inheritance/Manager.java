package com.msg.examples.se.inheritance;

import java.util.Objects;

public class Manager extends Employee {
    private double bonus;


    public Manager(String name, int age, double salary, int year, int month, int day) {
        super(name, age, salary, year, month, day);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void dance() {
        System.out.println("Dance status: No dance!");
    }

    @Override
    public double getSalary() {
//        double baseSalary = salary + bonus; // error: salary is private in Employee
//        double baseSalary = getSalary() + bonus; // no compile time error; StackOverflowError because getSalary refers to this method
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + getName()+ " , age: " + getAge() + " , position: " );
        sb.append("Manager{" +
                "bonus=" + bonus +
                '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Manager manager = new Manager("a", 1000, 1999, 12,12, 1);
        manager.setBonus(15);
        System.out.println(manager.getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return getName().equals(manager.getName())
                && getSalary() == manager.getSalary()
                && getHireDay().equals(manager.getHireDay());
    }


}

package com.msg.examples.se.inheritance;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
//        double baseSalary = salary + bonus; // error: salary is private in Employee
//        double baseSalary = getSalary() + bonus; // no compile time error; StackOverflowError because getSalary refers to this method
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public static void main(String[] args) {
        Manager manager = new Manager("a", 1000, 1999, 12,1);
        manager.setBonus(15);
        System.out.println(manager.getSalary());
    }
}

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
    @Override
    public void dance()
    {
        System.out.println("Busy");
    }
    @Override
    public boolean equals(Object otherObject) {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;

        Manager other = (Manager) otherObject;
        // test whether the fields have identical values
        return super.getName().equals(other.getName())
                && super.getSalary()== other.getSalary()
                && super.getHireDay().equals(other.getHireDay());
    }
    @Override
    public String toString()
    {
        return super.getName()+" "+super.getSalary()+ " "+super.getHireDay()+" "+bonus;
    }

}

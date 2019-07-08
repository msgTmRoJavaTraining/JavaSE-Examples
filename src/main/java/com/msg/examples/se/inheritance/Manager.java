package com.msg.examples.se.inheritance;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s, int year, int month, int day) {
        super(n,false, s, year, month, day);
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
    public void dance() {
        super.dance();
    }

    public double getBonus() {
        return bonus;
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
        Manager other = (Manager) otherObject;
        // test whether the fields have identical values
        return getName().equals(other.getName())
                && getBonus() == other.getBonus()
                && getSalary() == other.getSalary()
                && getHireDay().equals(other.getHireDay());
    }

     public String toString()
     {
         return super.toString()+" ,banous: "+this.getBonus();
     }
}

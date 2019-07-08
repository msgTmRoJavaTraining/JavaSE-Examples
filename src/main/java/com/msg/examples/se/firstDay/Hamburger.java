package com.msg.examples.se.firstDay;

public class Hamburger {
    private String name, expirationDate;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void changeWeight(int newWeight) {
       weight = weight + (newWeight * weight) / 100;
    }

    public static void main(String[] args) {
        Hamburger ham1 = new Hamburger();
        Hamburger ham2 = new Hamburger();
        Hamburger ham3 = new Hamburger();

        ham1.setName("Big Mac");
        ham1.setWeight(150);
        ham1.setExpirationDate("30.12.2019");

        ham2.setName("McChicken");
        ham2.setWeight(120);
        ham2.setExpirationDate("30.11.2019");

        ham3.setName("Cheeseburger");
        ham3.setWeight(135);
        ham3.setExpirationDate("17.10.2019");

        System.out.println("Cele trei tipuri de hamburgeri din meniul de astazi sunt:");
        System.out.println(ham1.getName() + " , greutate " + ham1.getWeight() + "gr");
        System.out.println(ham2.getName() + " , greutate " + ham2.getWeight() + "gr");
        System.out.println(ham3.getName() + " , greutate " + ham3.getWeight() + "gr");

        ham1.changeWeight(10); //150 -> 165
        ham2.changeWeight(10); //120 -> 132
        ham3.changeWeight(10); //135 -> 148,5

        System.out.println("\nSpecial astazi, McDonalds ofera o crestere a portiilor de hamurger cu 10%:");
        System.out.println(ham1.getName() + " , greutate " + ham1.getWeight() + "gr");
        System.out.println(ham2.getName() + " , greutate " + ham2.getWeight() + "gr");
        System.out.println(ham3.getName() + " , greutate " + ham3.getWeight() + "gr");
    }
}

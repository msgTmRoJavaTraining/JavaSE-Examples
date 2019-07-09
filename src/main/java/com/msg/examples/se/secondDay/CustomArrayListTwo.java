package com.msg.examples.se.secondDay;

import java.util.ArrayList;

public class CustomArrayListTwo<T extends Number> {
    private ArrayList<T> list = new ArrayList<>();

    void addElement(T element) {
        list.add(element);
    }

    void showElements() {
        for(T item : list) {
            System.out.println(item);
        }
    }

    void findElement(int position) {
        try {
            System.out.println(list.get(position));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nu exista niciun element la acest index!");
        }
    }

    public static void main(String[] args) {
        CustomArrayListTwo<Integer> myFirstCustomList = new CustomArrayListTwo<>();

        myFirstCustomList.addElement(1);
        myFirstCustomList.addElement(2);
        myFirstCustomList.addElement(3);

        System.out.println("Afisare iteme din FirstCustomArray");
        myFirstCustomList.showElements();

        System.out.println("\nCautare Item pe pozitia 1");
        myFirstCustomList.findElement(1);

        System.out.println("\nCautare Item pe pozitia 77");
        myFirstCustomList.findElement(77);
    }
}

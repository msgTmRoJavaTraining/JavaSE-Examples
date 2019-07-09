package com.msg.examples.se.secondDay;

import java.util.ArrayList;

public class CustomArrayListOne<T> {
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
        CustomArrayListOne<Object> myFirstCustomList = new CustomArrayListOne<>();

        myFirstCustomList.addElement("First Item");
        myFirstCustomList.addElement("Second Item");
        myFirstCustomList.addElement("Third Item");

        System.out.println("Afisare iteme din FirstCustomArray");
        myFirstCustomList.showElements();

        System.out.println("\nCautare Item pe pozitia 1");
        myFirstCustomList.findElement(1);

        System.out.println("\nCautare Item pe pozitia 77");
        myFirstCustomList.findElement(77);
    }
}

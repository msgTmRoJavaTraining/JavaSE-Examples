package com.msg.examples.se.collections;

import java.util.ArrayList;

public class Generics<T extends Number>
{

    private ArrayList<T> tab=new ArrayList<>();

    public void addElements (T elem)
    {
          tab.add(elem);
    }

    public T getElement(int index, ArrayList<T> tab )
    {
        if(index<0 || index > tab.size()) throw new ArrayIndexOutOfBoundsException();
        else
        return tab.get(index);
    }

    public ArrayList<T> getTab() {
        return tab;
    }

    public static void main(String[] args) {

        Generics<Number> customList =new Generics<>();

        Generics<Integer> customList1 =new Generics<>();

       // Generics<Object> customList2 =new Generics<>();


        customList.addElements(5);
        customList.addElements(10);
        customList.addElements(2.4);

        System.out.println(customList.getElement(2,customList.getTab()));



    }
}

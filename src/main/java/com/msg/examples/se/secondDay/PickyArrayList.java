package com.msg.examples.se.secondDay;

import java.util.ArrayList;

public class PickyArrayList <T extends Number>{
    ArrayList<T>  arr;
    public PickyArrayList() {
        arr=new ArrayList();
    }

    public void addElement(T item){

        arr.add(item);
    }

    public void showElemets(){
        System.out.println(arr);
    }

    public T getElemet(int index) {
        try {
            return arr.get(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
            return null;
        }
    }
}

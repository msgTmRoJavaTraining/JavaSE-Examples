package com.msg.examples.se.secondDay;

import java.util.*;

public class Generic1 <T extends Number> {
    private ArrayList<T> array= new ArrayList<>();

    public void addItem1(T item) {
        array.add(item);
    }

    public void getItem1(){
        for(T a:array){
            System.out.println(a);
        }
    }

    public void position1(int position){

        try {
            if (array.get(position)!=null) {
                System.out.println(position);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Position doesn't exist!");
        }
    }


    Generic1<Number> array1=new Generic1<>();


}

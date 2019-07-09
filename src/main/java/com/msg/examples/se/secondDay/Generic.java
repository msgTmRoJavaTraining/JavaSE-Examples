package com.msg.examples.se.secondDay;

import java.util.*;


public class Generic<T> {
    private ArrayList <T> array= new ArrayList<>();

    public void addItem(T item) {
        array.add(item);
    }

    public void getItem(){
        for(T a:array){
            System.out.println(a);
        }
    }

    public void position(int position){

            try {
                if (array.get(position)!=null) {
                    System.out.println(position);
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Position doesn't exist!");
            }
        }

    public static void main(String[] args){

      Generic<Object> array=new Generic<>();

      array.addItem("1");
      array.addItem("2");

      array.getItem();

      array.position(1);

    }

}

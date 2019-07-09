package com.msg.examples.se.collections;

public class MyMainClass {

    public static void main(String[] args){
                  MyArrayList<Number> lst = new MyArrayList<>();
                  lst.addItems(2);
                  lst.addItems(5.5);
                  lst.addItems(20);



    System.out.println(lst.getElement(5));
  }
}
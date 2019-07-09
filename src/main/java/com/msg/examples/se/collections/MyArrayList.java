package com.msg.examples.se.collections;
import java.lang.reflect.Array;
import java.util.*;
public class MyArrayList<T extends Number>{

    private ArrayList<T> item = new ArrayList<>();
    private int numberOfItems;



    public void addItems(T addItem) {
        item.add(addItem);
            }
    public T getElement(int pos)throws ArrayIndexOutOfBoundsException{

        for(int i = 0; i <= item.size(); i++){

            if(i == pos)
                return item.get(i);
        }
        throw new ArrayIndexOutOfBoundsException("Not found");
    }

}

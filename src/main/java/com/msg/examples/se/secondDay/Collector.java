package com.msg.examples.se.secondDay;

import java.util.ArrayList;
import java.util.List;

public class Collector <T extends Number>{
    private List<T> array = new ArrayList<>();
    public void addItem( T item){
        array.add(item);
    }

        public Object getElement(int index){
        if(index >= array.size())throw new ArrayIndexOutOfBoundsException();
        else return array.get(index);
    }

}

package com.msg.examples.se.secondDay;

import java.util.*;

public class ArrayListV1<T> {
    private List<T> elements = new ArrayList<>();

    public T getElement(int i) {
        if(i>= elements.size())throw  new ArrayIndexOutOfBoundsException();
        else
            return elements.get(i);
    }

    public void addElement(T element) {
        elements.add(element);
    }
}


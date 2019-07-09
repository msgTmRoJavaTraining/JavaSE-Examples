package com.msg.examples.se.secondDay;

import java.util.ArrayList;
import java.util.List;

public class ArrayListV2<T extends Number> {
    private List<T> elements = new ArrayList<>();

    public T getElement(int i) {
        if (i >= elements.size()) throw new ArrayIndexOutOfBoundsException();
        else
            return elements.get(i);
    }

    public void addElement(T element) {
        elements.add(element);
    }
}

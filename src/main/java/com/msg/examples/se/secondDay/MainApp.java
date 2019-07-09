package com.msg.examples.se.secondDay;

public class MainApp {
    public static void main(String args[])
    {
    PickyArrayList <Number>intArr=new PickyArrayList<>();
    intArr.addElement(2);
        intArr.addElement(1);
        intArr.addElement(3);
        intArr.addElement(4);
        intArr.showElemets();
        System.out.println(intArr.getElemet(3));
    }
}

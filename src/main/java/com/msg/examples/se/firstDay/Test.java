package com.msg.examples.se.firstDay;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        int sum=0;
        int index = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        for(int i=0; i<=(list.size()-1); i++){
            if((list.indexOf(i)%2)!= 0){
                sum= sum + list.get(i);
            }
            /*else{
                continue;
            }*/
        }
        sum = 0;
        while(index <= list.size()-1){
            if((list.indexOf(index)%2) != 0){
                sum= sum + list.get(index);
            }
            index = index +1;
        }
        index =0;
        sum = 0;
        do{
            if((list.indexOf(index)%2) != 0){
                sum= sum + list.get(index);
            }

            index = index +1;
        }while(index <= list.size()-1);

        System.out.println(sum);

    }
}

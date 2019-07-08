package com.msg.examples.se.firstDay;

import com.sun.corba.se.impl.transport.EventHandlerBase;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String args[]){
       /* int sum=0;
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
            else{
                continue;
            }
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

        System.out.println(sum);*/
       Hamburger h1 = new Hamburger("hamburger1", 12.5, "12/07/2019");
       Hamburger h2 = new Hamburger("hamburger2", 12.7, "13/07/2019");
       Hamburger h3 = new Hamburger("hamburger3", 45.8, "14/07/2019");
       h3.changeWeight(10);
       List<Hamburger>hamburgers= new ArrayList<>();
       hamburgers.add(h1);
       hamburgers.add(h2);
       hamburgers.add(h3);
       for(Hamburger h: hamburgers){
           System.out.println(h);
       }

       Car car1 = new Car();
       Car car2 = new Car("white");
       Car car3 = new Car(2, "blue");
       List<Car> cars = new ArrayList<>();
       cars.add(car1);
       cars.add(car2);
       cars.add(car3);
       for(Car c: cars){
            System.out.println(c);
       }
    }
}

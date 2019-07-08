package com.msg.examples.se.FirstDay;

import java.util.HashMap;

public class FirstClass {
   public static void main(String args[])
   {
       Hamburger ham1=new Hamburger();
       Hamburger ham2=new Hamburger();
       Hamburger ham3=new Hamburger();

       ham1.setName("Hamzy1");
       ham1.setWeight(100);
       ham1.setExpire("2020/01/01");

       ham2.setName("Hamzy2");
       ham2.setWeight(50);
       ham2.setExpire("2020/01/01");

       ham3.setName("Hamzy3");
       ham3.setWeight(200);
       ham3.setExpire("2020/01/01");


       System.out.println(ham1.getName()+ " "+ham1.getWeight());
       System.out.println("After raise(25): "+ham1.getName()+ " "+ham1.raise(25));


   }

}

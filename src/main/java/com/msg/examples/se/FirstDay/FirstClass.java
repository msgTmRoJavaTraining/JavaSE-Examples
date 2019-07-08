package com.msg.examples.se.FirstDay;

public class FirstClass {
   public static void main(String args[])
   {
        //FOR
       for(int i=0;i<10;i++)
       {
           if(i%2==0)continue;
           System.out.println(i+" ");
       }
       int i=0;
       //DO
       do{
           if(i%2!=0)
               System.out.println(i+" ");

           i=i+1;
       }while(i<10);
    i=0;
       //WHILE
       while(i!=10){

           if(i%2!=0)
               System.out.println(i+" ");
           i=i+1;
       }


   }

}

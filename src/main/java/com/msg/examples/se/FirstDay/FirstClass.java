package com.msg.examples.se.FirstDay;

public class FirstClass {
   public static void main(String args[])
   {
        //FOR
       int sum=0;
       for(int i=0;i<10;i++)
       {
           if(i%2==0)continue;
           System.out.println(i+" ");
           sum=sum+i;
       }
       System.out.println("sum(for)"+sum);
       int i=0;
       //DO
       sum=0;
       do{
           if(i%2!=0) {
               System.out.println(i + " ");
               sum=sum+i;
           }

           i=i+1;
       }while(i<10);
       System.out.println("sum(for)"+sum);
    i=0;
       //WHILE
       sum=0;
       while(i!=10){

           if(i%2!=0) {
               System.out.println(i + " ");
               sum=sum+i;
           }
           i=i+1;
       }
       System.out.println("sum(for)"+sum);


   }

}

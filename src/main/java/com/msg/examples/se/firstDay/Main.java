package com.msg.examples.se.firstDay;

public class Main{

    public int sumFor(){
        int sum = 1;
        for(int i = 1;i<=10;i++){

            sum=sum+2;
        }
        return sum;
    }

    public int sumWhile(){
        int i = 1;
        int flag = 1;
        int sum = 0;
        while(flag <= 10)
        {
            if(i % 2 == 0)
                continue;
            sum+=i;
            i++;
            flag++;

        }
       return sum;
    }

    public int sumDoWhile(){

        int a = 1;
        int sum = 1;
        do {
            sum+=2;
            a++;
        }while(a<=10);
             return sum;
    }

    public static void main(String[] args) {
       Main m1= new Main();

       System.out.println(m1.sumFor());
       System.out.println(m1.sumWhile());
       System.out.println(m1.sumDoWhile());
    }
}

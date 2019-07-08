package com.msg.examples.se.firstDay;

public class myClass {
    public static void main(String[] args) {
        int sum=0;
        int i=0;
        for(i=1;i<11;i++)
        {
            if(i%2!=0)
                sum+=i;
        }

        System.out.println(sum);

        while(++i<=10)
        {
            if(i%2==0) continue;
            sum+=i;
        }

        System.out.println(sum);

        do {
            if(i%2==0) continue;
            sum+=i;

        }while (++i<10);

        System.out.println(sum);
    }
    }

package com.msg.examples.se.firstPack;

public class Main
{

    public static void main(String[] args) {

        int s=0;
        for(int i=0;i<20;i++)
        {
            if(i%2==0) continue;
            else
                s=s+i;
        }

        System.out.println(s);


        int j=1,nr=0,s1=0;
        while(nr<10)
        {
            s1=s1+j;
            nr++;
            j=j+2;
        }

        System.out.println(s1);

        int k=1,s2=0;
        do {

            if(k%2==1)
            s2=s2+k;
            k++;

        }while(k<20);

        System.out.println(s2);

    }
}

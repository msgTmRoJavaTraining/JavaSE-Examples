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



        Hamburger h1=new Hamburger();
        Hamburger h2=new Hamburger();
        Hamburger h3=new Hamburger();


        h1.setName("Mexican");
        h1.setWeight(5.5);
        h1.setExpDate("21.07.2019");

        h2.setName("American");
        h2.setWeight(10);
        h2.setExpDate("15.07.2019");

        h3.setName("Spanish");
        h3.setWeight(2.5);
        h3.setExpDate("28.07.2019");

        System.out.println("Hamburger: "+h1.getName()+" - weight: "+h1.getWeight());
        System.out.println("Hamburger: "+h2.getName()+" - weight: "+h2.getWeight());
        System.out.println("Hamburger: "+h3.getName()+" - weight: "+h3.getWeight());

        h1.weightRaise(25);
        h2.weightRaise(10);
        h3.weightRaise(50);

        System.out.println("Hamburger: "+h1.getName()+" - weight after raise: "+h1.getWeight());

        System.out.println("Hamburger: "+h2.getName()+" - weight after raise: "+h2.getWeight());

        System.out.println("Hamburger: "+h3.getName()+" - weight after raise: "+h3.getWeight());

    }
}

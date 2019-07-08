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
             if(i % 2 != 0) {
                 sum += i;
             }
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

       Hamburger h1 = new Hamburger();
       h1.setName("hamburger 1");
       h1.setWeight(1.5);
       h1.setExpirationDate("12/12/2019");
       System.out.println(h1.getName());
       System.out.println(h1.getWeight());
       System.out.println(h1.setPercentWeight(10));


       Hamburger h2 = new Hamburger();
        h2.setName("hamburger 2");
        h2.setWeight(1.0);
        h2.setExpirationDate("25/12/2019");
        System.out.println(h2.getName());
        System.out.println(h2.getWeight());
        System.out.println(h2.setPercentWeight(20));


       Hamburger h3 = new Hamburger();
       h3.setName("hamburger 3");
       h3.setWeight(2.5);
       h3.setExpirationDate("30/12/2019");
       System.out.println(h3.getName());
       System.out.println(h3.getWeight());
       System.out.println(h3.setPercentWeight(50));


        Car c1 = new Car();
        System.out.println(c1.toString());
        Car c2 = new Car("red");
        System.out.println(c2.toString());
        Car c3 = new Car("white",7);
        System.out.println(c3.toString());
    }




}

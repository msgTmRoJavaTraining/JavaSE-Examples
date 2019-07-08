package com.msg.examples.se.firstDay;



class Main {

    public static void main(String[] args) {

        int sum = 0, i=0;

        for (i = 0; i < 10; i++) {
            if (i % 2 != 0)
                sum += i;
        }

        System.out.println(sum);

        sum=0;
        i=0;

        while (i <= 10) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
            i++;
        }
        System.out.println(sum);


        sum=0;
        i=0;
        do {
            if (i % 2 != 0) {
                sum = sum + i;
            }
            i++;

             if(i==0)
            continue;
        }
        while (i <= 10);

        System.out.println(sum);

    }
}


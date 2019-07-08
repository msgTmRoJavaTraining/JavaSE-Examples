package com.msg.examples.se.firstDay;

public class Main {

    public static void main(String[] args) {
        int sum = 0, i = 0;

        for(i = 0; i <= 10; i++) {
            if(i % 2 != 0) {
                sum = sum + i;
            }
        }

        System.out.println("Suma(for) este: " + sum);

        i = 0;
        sum = 0;
        while(i <= 10) {
            if(i % 2 != 0) {
                sum = sum + i;
            }

            i = i + 1;
        }

        System.out.println("Suma(while) este: " + sum);

        i = 0;
        sum = 0;
        do {
            if(i == 0) {
                i = i + 1;
                System.out.println("Continue reached.");
                continue;
            } else {
                if(i % 2 != 0) {
                    sum = sum + i;
                }

                i = i + 1;
            }
        } while(i <= 10);

        System.out.println("Suma(do_while) este: " + sum);
    }
}

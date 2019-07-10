package com.msg.examples.se.interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class MyMain {

    private static final String NEW_LINE="---------------------------";

    public static void main(String[] args) {


        StringComparator sc = new StringComparator();

        String[] staff = new String[3];

        staff[0] = "Baaa";
        staff[1] = "Masacuvocale";
        staff[2] = "Scaun";

        String[] staff1 = Arrays.copyOf(staff, staff.length);
        String[] staff2 = Arrays.copyOf(staff, staff.length);
        String[] staff3 = Arrays.copyOf(staff, staff.length);

        Arrays.sort(staff, sc);
        afiseaza(staff);

        Comparator<String> numberOfVowelsComparatorWithLambdaExpression =
                (s1, s2) ->
                        Integer.compare(getNumberOfVowels(s1),getNumberOfVowels(s2));


        Arrays.sort(staff2,numberOfVowelsComparatorWithLambdaExpression);
        System.out.println(NEW_LINE);
        afiseaza(staff2);

        System.out.println(NEW_LINE);


         Integer tab[]=new Integer[3];
         tab[0]=12378;
         tab[1]=56778;
         tab[2]=65203;

        Comparator<Integer>  numberOfDigitsGreaterThanFiveComparatorWithAnnonymousClass=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(getNumberOfDigitsGreaterThanFive(o2),getNumberOfDigitsGreaterThanFive(o1));
            }
        };

        Arrays.sort(tab,numberOfDigitsGreaterThanFiveComparatorWithAnnonymousClass);
        System.out.println(NEW_LINE);

        printInt(tab);
    }



    public static void afiseaza(String []staff)
    {
        for(String elem: staff)
            System.out.println(elem);
    }

    public static int getNumberOfVowels(String str)
    {
        int nr=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            nr++;
        }
        return nr;
    }

    public static int getNumberOfDigitsGreaterThanFive(int n)
    {
        int nr=0;

        while(n>0)
        {
            if(n%10>5)
            nr++;
            n=n/10;
        }
        return nr;
    }

    public static void printInt(Integer []tab)
    {
        for(int i=0;i<3;i++)
            System.out.println(tab[i]);
    }





}

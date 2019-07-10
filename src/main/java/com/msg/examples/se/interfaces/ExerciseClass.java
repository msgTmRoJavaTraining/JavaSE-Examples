package com.msg.examples.se.interfaces;

import java.util.Arrays;
import java.util.Comparator;


 class ComparatorClass implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        if(str1.length() < str2.length())
            return -1;
        else if(str1.length() > str2.length())
            return 1;
        else return 0;
    }
}


class IntegerHelper{

     public static int getDigitsGrater(int x){
         int p = 0;//p used to cound number of digits grater than 5
         while(x != 0){
             if(x%10 >5)
                 p++;
             x = x/10;
         }
         return p;
     }
 }


 class IntegerComparator implements Comparator<Integer>{
     @Override
     public int compare(Integer int1, Integer int2) {
         if(int1 < int2)
             return -1;
         else if(int1 > int2)
             return 1;
         else return 0;
     }

 }


 public class ExerciseClass {

       private static final String NEW_PARAGRAPH_JUMP = "\n---------------------------\n";
    public static int count_Vowels(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            {
                count++;
            }
        }
        return count;
    }
       public static void printString(String[] str){

           for(int i = 0;i <str.length ; i++)
               System.out.println(str[i]+"\n");
       }
       public static void main(String[] args) {

           ComparatorClass compar = new ComparatorClass();


           String[] sir = new String[5];
           sir[0] = "masina";
           sir[1] = "mar";
           sir[2] = "banana";
           sir[3] = "aa";
           sir[4] = "maamamamaaaaa";
           String[] sir1 = Arrays.copyOf(sir, sir.length);
           Arrays.sort(sir, compar);
           printString(sir);

           System.out.println(NEW_PARAGRAPH_JUMP);

           Comparator<String> comp = (string1, string2) ->
                   ExerciseClass.count_Vowels(string1) > ExerciseClass.count_Vowels(string2) ? 1
                           : (ExerciseClass.count_Vowels(string1) < ExerciseClass.count_Vowels(string2) ? -1 : 0);
           Arrays.sort(sir1, comp);
           printString(sir1);
           System.out.println(NEW_PARAGRAPH_JUMP);



           Comparator<Integer> compInt = new Comparator<Integer>() {
               @Override
               public int compare(Integer int1,Integer int2) {
                   return Integer.compare(IntegerHelper.getDigitsGrater(int1),IntegerHelper.getDigitsGrater(int2));
               }
           };

        Integer[] myInt = {12121,2226,6666,122,1899,5551};
        Arrays.sort(myInt,compInt);
        for(int i = 0; i < myInt.length;i++)
            System.out.println(myInt[i] + " ");
           System.out.println(NEW_PARAGRAPH_JUMP);
    }

}

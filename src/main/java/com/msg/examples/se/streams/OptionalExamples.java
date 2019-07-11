package com.msg.examples.se.streams;

import java.util.Optional;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class OptionalExamples {
    public void stringFromList(List lst){

        System.out.println(lst.stream().reduce("" , (sum, lastLength)
                          -> {
                               if(sum == ""){if((int)lastLength % 2 == 0) {
                                     return sum + "e" + lastLength;
                                 }else{
                                      return sum + "o"+lastLength ;
                                      }
                                  }else{if((int)lastLength % 2 == 0) {
                                      return sum + ",e" + lastLength;
                                        }else{
                                      return sum + ",o"+lastLength ;
                                                       }}}));
    }
    public static void infiniteStreamGenerator(){
        System.out.println("\nStreaming 5 random doubles:");
        Random randomGenerator = new Random();
        Stream.iterate(ThreadLocalRandom.current().nextDouble(0,10), n -> ThreadLocalRandom.current().nextDouble(0,10)).limit(5).forEach(System.out::println);

        System.out.println("\nCreating a list with 10 random doubles:");
        ArrayList<Double> listOfRandomDoubles=new ArrayList<>();
        Stream.iterate(randomGenerator.nextDouble()*10, n -> randomGenerator.nextDouble()*10).limit(10).forEach(value -> listOfRandomDoubles.add(value));
        Iterator<Double> iterator=listOfRandomDoubles.iterator();

        int cnt=0;
        while (iterator.hasNext()){
            cnt++;
            System.out.println("Place: "+cnt+" - Value: "+iterator.next());
        }

        System.out.println("\nCreating an array with 20 random doubles:");
        Integer[] cnt2=new Integer[]{0};
        Double[] arrayOfRandomDoubles=new Double[21];
        Stream.iterate(randomGenerator.nextDouble()*10, n -> randomGenerator.nextDouble()*10).limit(20).forEach(value -> { cnt2[0]++;arrayOfRandomDoubles[cnt2[0]]=value;});

        for (int i=1;i< arrayOfRandomDoubles.length;i++)
            System.out.println("Place in array: "+ i+" - Value: "+arrayOfRandomDoubles[i]);
    }

    public static void main(String[] args) throws Exception {
        Optional<String> opt = Optional.of("mere");
        opt.ifPresent(name -> System.out.println(name.length()));

        String name = Optional.<String>empty().orElse("John");
        System.out.println(name);

        String anotherName = Optional.<String>empty().orElseGet(() -> "Jena");
        System.out.println(anotherName);

        Optional.<String>empty().orElseThrow(() -> new Exception("I'm failing"));
    }
}

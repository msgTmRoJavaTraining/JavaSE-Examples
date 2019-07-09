package com.msg.examples.se.collections;

import java.util.*;

public class CollectionsUtil {

  public static <T> void forEachInternalCollection(Collection<T> collection) {
    collection.forEach(element -> System.out.print(element + " "));

    System.out.print("\n");

    collection.forEach(System.out::println);
  }

  public static <T> void forEachExternalCollection(Collection<T> collection) {
    for(T element : collection) {
      System.out.print(element + " ");
    }

    System.out.print("\n");
  }

  public static <T> void iterateCollection(Collection<T> collection) {
    Iterator<T> iterator = collection.iterator();
    while (iterator.hasNext()) {
      T element = iterator.next();
      System.out.print(element + " ");
    }

    System.out.print("\n");
  }

  public static void removeFirstOccurence(ArrayList<Integer> array,Integer x){

            array.remove(x);
    }
   public static void removeGivenLength(ArrayList<String>array,int givenLength){

        ArrayList<String> tmp = new ArrayList<String>();
        for(String a:array){
          if(a.length()==givenLength)
            tmp.add(a);
        }
        array.removeAll(tmp);
   }
   //the following method add element by a given option
   public static void addElementsToLinkedList(LinkedList<Integer> list,String option,Integer x){

       if(option == "first") {
         list.addFirst(x);
            }else {
               list.addLast(x);
                  }
       }
   public static void iteratesHashSet(HashSet<Integer> mySet){

     mySet.forEach(element -> System.out.print(element + " "));

   }

   public static void associateNumberWithWords(Map<Integer,String> myMap){
     Iterator it = myMap.entrySet().iterator();
     while (it.hasNext()) {
       Map.Entry pair = (Map.Entry)it.next();
       System.out.println(pair.getKey() + " = " + pair.getValue());
   }
}
}

package com.msg.examples.se.collections;

import java.util.*;

public class Lists {

  public static void main(String args[]) {
    ArrayList<String> string_array = new ArrayList<>();
    ArrayList<Integer> array = new ArrayList<>();
    LinkedList<Integer> linked = new LinkedList<>();
    HashSet<Integer> hash = new HashSet<>();
    Map<Integer,String> map = new TreeMap<>();


    array.add(8);
    array.add(0, 5);
    array.add(2);
    array.add(4);

    //Exercise 1
    CollectionsUtil.removeFirstOccurence(array,5);
    for (int i:array
    ) {System.out.println(i);

    }

    //Exercise 2
    System.out.println();
    string_array.add("asd");
    string_array.add("asdasd");
    string_array.add("asdasdasd");
    string_array.add("asd");
    string_array.add("asdasd");
    CollectionsUtil.removeGivenLength(string_array,3);
    for (String i:string_array
    ) {System.out.println(i);

    }

    //Exercise 3
    System.out.println();
    Integer[] elements = {2,3,4,5};
    CollectionsUtil.insertFirstAndLast(linked,elements);
    linked.forEach(System.out::println);

    //Exercise 4
    System.out.println();
    hash.add(5);
    hash.add(1);
    hash.add(2);
    CollectionsUtil.iterateThroughHashSet(hash);

    //Exercise 5
    System.out.println();
    map.put(1,"one");
    map.put(2,"two");
    map.put(3,"three");
    CollectionsUtil.getTheWord(map,2);
    CollectionsUtil.getTheWord(map,3);
    CollectionsUtil.getTheWord(map,7);

//    CollectionsUtil.iterateCollection(array);
//    System.out.println("Min = " + Collections.min(array));
//
//    LinkedList<Integer> linked = new LinkedList<>(array);
//    linked.addLast(10);
//    linked.addFirst(10);
//    CollectionsUtil.forEachExternalCollection(linked);
//    System.out.println("Max = " + Collections.max(linked));
//    Collections.replaceAll(linked, 10, 7);
//    CollectionsUtil.forEachInternalCollection(linked);
//    System.out.println("Exists = " + Collections.binarySearch(linked, 7));
//    Collections.sort(linked);
//    System.out.println("Exists = " + Collections.binarySearch(linked, 7));


  }


}

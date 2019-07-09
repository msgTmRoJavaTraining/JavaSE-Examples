package com.msg.examples.se.collections;

import java.util.*;

public class Lists {

  public static void main(String args[]) {

    ArrayList<Integer>  array = new ArrayList<>();
    array.add(8);
    array.add(0, 5);
    array.add(2);
    array.add(4);
    array.add(2);
    CollectionsUtil.removeFirstOccurence(array,2);
    CollectionsUtil.iterateCollection(array);
    System.out.println("Min = " + Collections.min(array));

    ArrayList<String>  stringArray = new ArrayList<String>();
    stringArray.add("mar");
    stringArray.add("para");
    stringArray.add("car");
    stringArray.add("echipa");
    CollectionsUtil.removeGivenLength(stringArray,3);
    CollectionsUtil.iterateCollection(stringArray);

    LinkedList<Integer> linked = new LinkedList<>(array);
    linked.addLast(10);
    linked.addFirst(10);
    CollectionsUtil.addElementsToLinkedList(linked,"first",5);
    CollectionsUtil.addElementsToLinkedList(linked,"last",12);
    CollectionsUtil.addElementsToLinkedList(linked,"a",15);
    CollectionsUtil.iterateCollection(linked);
    System.out.println("\n");
    CollectionsUtil.forEachExternalCollection(linked);
    System.out.println("Max = " + Collections.max(linked));
    Collections.replaceAll(linked, 10, 7);
    CollectionsUtil.forEachInternalCollection(linked);
    System.out.println("Exists = " + Collections.binarySearch(linked, 7));
    Collections.sort(linked);
    System.out.println("Exists = " + Collections.binarySearch(linked, 7));
    System.out.println("\n");

    HashSet<Integer> hashSet = new HashSet<Integer>();
    hashSet.add(1);
    hashSet.add(5);
    hashSet.add(0);
    CollectionsUtil.iteratesHashSet(hashSet);

    System.out.println("\n");
    Map<Integer,String> myMap = new HashMap<Integer, String>();
    myMap.put(1,"unu");
    myMap.put(2,"doi");
    myMap.put(3,"trei");

    CollectionsUtil.associateNumberWithWords(myMap);

  }


}

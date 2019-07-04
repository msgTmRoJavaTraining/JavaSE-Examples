package com.msg.examples.se.collections;

import java.util.*;

public class Lists {

  public static void main(String args[]) {
    ArrayList<Integer>  array = new ArrayList<>();
    array.add(8);
    array.add(0, 5);
    array.add(2);
    array.add(4);
    CollectionsUtil.iterateCollection(array);
    System.out.println("Min = " + Collections.min(array));

    LinkedList<Integer> linked = new LinkedList<>(array);
    linked.addLast(10);
    linked.addFirst(10);
    CollectionsUtil.forEachExternalCollection(linked);
    System.out.println("Max = " + Collections.max(linked));
    Collections.replaceAll(linked, 10, 7);
    CollectionsUtil.forEachInternalCollection(linked);
    System.out.println("Exists = " + Collections.binarySearch(linked, 7));
    Collections.sort(linked);
    System.out.println("Exists = " + Collections.binarySearch(linked, 7));
  }


}

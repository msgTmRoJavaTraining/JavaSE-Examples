package com.msg.examples.se.collections;

import java.util.*;

public class Lists {

  public static void main(String args[]) {
    /*
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
     */

    ArrayList ints=new ArrayList();
    ints.add(10);
    ints.add(21);
    ints.add(11);
    ints.add(7);
    ints.add(40);
    ints.add(1);
    ints.add(3);
    ints.add(10);
    LinkedList strings=new LinkedList();
    strings.add("Bill");
    strings.add("Steve");
    strings.add("Dy");
    strings.add("George");
    strings.add("Claus");
    HashSet hSet=new HashSet();
    hSet.add(10);
    hSet.add(21);
    hSet.add(11);
    hSet.add(7);
    hSet.add(40);
    hSet.add(1);
    Map mapz=new HashMap();
    mapz.put(1,"NumbaUan");
    mapz.put(2,"duoz");
    mapz.put(3,"triiiii");
    //ex1
    CollectionsUtil.forEachExternalCollection(ints);
    CollectionsUtil.removeFirstOccurrence(ints,10);
    CollectionsUtil.forEachExternalCollection(ints);
    //ex2
    CollectionsUtil.forEachExternalCollection(strings);
    //CollectionsUtil.removeGivenLength(strings,20);
    //ex3
    CollectionsUtil.addFirstAndLast(strings,"Upppa");
    CollectionsUtil.addFirstAndLast(strings,"uhuuu");
    CollectionsUtil.forEachExternalCollection(strings);

    //ex4
    System.out.println(hSet);

    //ex5
    System.out.println(mapz);
    System.out.println(mapz.get(1));




  }


}

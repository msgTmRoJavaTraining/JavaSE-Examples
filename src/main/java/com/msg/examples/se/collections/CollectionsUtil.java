package com.msg.examples.se.collections;

import java.util.*;

public class CollectionsUtil {

  public static <T> void forEachInternalCollection(Collection<T> collection) {
    collection.forEach(element -> System.out.print(element + " "));

    System.out.print("\n");

    collection.forEach(System.out::println);
  }

  public static <T> void forEachExternalCollection(Collection<T> collection) {
    for (T element : collection) {
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

  public static void removeFirstOccurence(ArrayList<Integer> list, int specified_element) {
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      Integer element = iterator.next();
      if (element.equals(specified_element)) {
        iterator.remove();
      }
    }
  }

  public static void removeGivenLength(ArrayList<String> ArrayListofStrings, int givenLength) {
    Iterator<String> iterator = ArrayListofStrings.iterator();
    while (iterator.hasNext()) {
      String value = iterator.next();
      if (value.length() == givenLength) {
        iterator.remove();
      }
    }
  }

  public static void insertFirstAndLast(LinkedList<Integer> list, Integer[] elementsToAdd) {
    for (Integer i : elementsToAdd
    ) {
      list.addFirst(i);
    }

    for (Integer i : elementsToAdd
    ) {
      list.addLast(i);
    }
  }

  public static void iterateThroughHashSet(HashSet<Integer> hashSet) {
    Iterator<Integer> it = hashSet.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  public static void getTheWord(Map<Integer,String> map,int value)
  {
    if(map.containsKey(value))
    {
      map.get(value);
    }
    else
      System.out.println("The key: -"+value+"- doesn't exist!");
  }
}

package com.msg.examples.se.collections;

import java.util.Collection;
import java.util.Iterator;

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
}

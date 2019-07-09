package com.msg.examples.se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

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
  public static <T> void removeFirstOccurrence(ArrayList<T> collection,int toDelete){
    if(collection.indexOf(toDelete)<0)System.out.println("No action performed");
    else collection.remove(collection.indexOf(toDelete));


  }
  public static <T>  void removeGivenLength(ArrayList<T> collection, int len){
    Iterator<T> iterator = collection.iterator();
    while (iterator.hasNext()) {
      if(((String)iterator.next()).length()==len)
        iterator.remove();
    }
  }
  public static <T> void addFirstAndLast(LinkedList collection, String toAdd) {
    collection.addFirst(toAdd);
    collection.addLast(toAdd);
  }
  public static <T> void associationWords() {


  }


}

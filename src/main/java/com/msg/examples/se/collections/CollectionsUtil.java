package com.msg.examples.se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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


  public static void removeFirstOccurance(int x, ArrayList<Integer> list) {
    Iterator<Integer> iterator = list.iterator();

    while (iterator.hasNext()) {
      int element = iterator.next();
      if (element == x) {
        list.remove(list.indexOf(element));
        break;
      }
    }
  }

  public static void insertLinkedList(String first, LinkedList<String> list, String option) {
    if (option.equals("primul"))
      list.addFirst(first);
    else if (option.equals("ultimul"))
      list.addLast(first);
  }

  public static void iteratesHashSet(HashSet<String> set) {
    set.forEach(System.out::println);
  }

  public static void removeGivenLength(int x, ArrayList<String> list) {

    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {
      String element = iterator.next();
      if (element.length() == x) {
        iterator.remove();
      }
    }
  }


  public static void parcurgeMap(Map<Integer,String> map)
  {
    for(int element : map.keySet())
    {
      System.out.println(element + " -> "+ map.get(element));
    }
  }

  public static void main(String[] args) {


    Map <Integer,String> dictionar=new HashMap<>();


    dictionar.put(2,"two");
    dictionar.put(3,"three");
    dictionar.put(4,"for");
    dictionar.put(5,"five");

    parcurgeMap(dictionar);



    ArrayList<String> listaStringuri =new ArrayList<>();

    listaStringuri.add("Ana");
    listaStringuri.add("Ioana");
    listaStringuri.add("Adrei");

    forEachExternalCollection(listaStringuri);

    // ------------remove given length----------------

    removeGivenLength(5,listaStringuri);

    forEachExternalCollection(listaStringuri);


   // ---------------- remove first occurance ---------------------

    ArrayList<Integer> listaIntregi =new ArrayList<>();

    listaIntregi.add(2);
    listaIntregi.add(3);
    listaIntregi.add(4);
    listaIntregi.add(5);
    listaIntregi.add(3);

    forEachExternalCollection(listaIntregi);

    removeFirstOccurance(3,listaIntregi);

    forEachExternalCollection(listaIntregi);

//-------------------insert at the first and last position--------------

    LinkedList<String> listaStringuriLinked =new LinkedList<>();


    insertLinkedList("Maria",listaStringuriLinked,"primul");
    insertLinkedList("Marius",listaStringuriLinked,"primul");
    insertLinkedList("Ion",listaStringuriLinked,"primul");
    insertLinkedList("Ionut",listaStringuriLinked,"primul123");

    insertLinkedList("Mara",listaStringuriLinked,"ultimul");

    forEachExternalCollection(listaStringuriLinked);


  

    HashSet<String> h = new HashSet<String>();

    h.add("India");
    h.add("Australia");
    h.add("South Africa");
    h.add("India");

    iteratesHashSet(h);


  }

}

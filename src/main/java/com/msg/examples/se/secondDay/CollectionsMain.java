package com.msg.examples.se.secondDay;

import java.util.*;

public class CollectionsMain {
    static ArrayList<String> myList = new ArrayList<String>();

    public static void main(String[] args) {
        myList.add("Hello");
        myList.add("World");
        myList.add("Hello");
        myList.add("Hello");
        myList.add("Food");
        myList.add("Food");

        System.out.println("Afisarea initiala a listei");
        for (String s : myList) {
            System.out.println(s);
        }

        for(int i = 0; i < myList.size(); i++) {
            if(myList.get(i).equals("Hello")) {
                myList.remove(i);
                break;
            }
        }

        System.out.println("Afisarea listei dupa prima aparitie a cuvantului Hello");
        for (String s : myList) {
            System.out.println(s);
        }

        removeGivenLength(myList, 4);
        System.out.println("Afisarea listei dupa stergerea cu metoda removeGivenLength - 4 caractere");
        myList.forEach(myList -> System.out.println(myList));

        addElementsInLinkedList();

        goThroughElementsFromHashSet();

        activateHashMapExample();
    }

    private static void activateHashMapExample() {
        Map<Integer, String> myHashMap = new HashMap<Integer, String>();

        myHashMap.put(1, "Big Mac");
        myHashMap.put(2, "Cheeseburger");
        myHashMap.put(3, "McChicken");
        myHashMap.put(4, "McFlurry");

        Set<Map.Entry<Integer, String>> valuesSet = myHashMap.entrySet();

        System.out.println("\nAfisare HashMap:");
        for(Map.Entry<Integer, String> item : valuesSet) {
            System.out.println("Item: " + item.getKey() + " - " + item.getValue());
        }

    }

    private static void goThroughElementsFromHashSet() {
        HashSet<String> myHashSet = new HashSet<String>();

        myHashSet.add("Tokyo");
        myHashSet.add("Oslo");
        myHashSet.add("Bucharest");
        myHashSet.add("London");

        System.out.println("\nAfisare HashSet:");
        Iterator<String> mySecondIterator = myHashSet.iterator();
        while(mySecondIterator.hasNext()) {
            System.out.println(mySecondIterator.next());
        }
    }

    private static void addElementsInLinkedList() {
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

        myLinkedList.add(1);
        myLinkedList.add(2);

        System.out.println("\nAfisare LinkedList originala\n" + myLinkedList);

        myLinkedList.addFirst(0);
        myLinkedList.addLast(5);

        System.out.println("\nAfisare LinkedList dupa adaugarea de elemente\n" + myLinkedList);
    }

    private static void removeGivenLength(ArrayList<String> myList, int givenLength) {
        Iterator<String> myIterator = myList.iterator();

        while(myIterator.hasNext()) {
            if(myIterator.next().length() == givenLength) {
                myIterator.remove();
            }
        }
    }
}

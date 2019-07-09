package com.msg.examples.se.secondDay;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.*;

public class Main {
    public static void removeFirstElem(ArrayList<Integer> array){
        ArrayList<Integer> result = array;
        if(array.size()!=0) {
            result.remove(0);
            Main.forEachArray(result);
        }
        else{
            System.out.println(" Array is empty");
        }

    }
    public static void forEachArray(ArrayList<Integer> array){
        System.out.println("Integer array : ");
        array.forEach(element -> System.out.print(element + " "));
        System.out.println("\n");
    }
    public static void forEachStringArray(ArrayList<String> array){
        System.out.println("String array : ");
        for(String i : array){
            System.out.println(i + " ");
        }
        System.out.println("\n");
    }
    public static void forEachLinkedList(LinkedList<Integer>list){
        System.out.println("LinkedList elements: ");
        for(Integer i : list){
            System.out.println(i + " ");
        }
        System.out.println("\n");
    }
    public static void removeGivenLength(ArrayList<String> array){
        int length = 4;
        List<String> toRemove = new ArrayList<>();
        Iterator<String> iterator = array.iterator();
        while(iterator.hasNext()) {
            String elem = iterator.next();
            if(Main.checkLenght(elem, length)){
                toRemove.add(elem);
            }
        }
        array.removeAll(toRemove);
        Main.forEachStringArray(array);
    }
    public static boolean checkLenght(String s, int lenght){
        if(s.length() == lenght){
            return true;
        }else{
            return false;
        }
    }
    public static void insertInLinkedList(LinkedList<Integer>given, Integer elem, boolean where){
        if(where == true){
            given.addFirst(elem);
        }else{
            given.addLast(elem);
        }
    }
    public static void interateSet (Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        System.out.println("Set elements: ");
        while(iterator.hasNext()) {
            int elem = iterator.next();
            System.out.println( elem + " ");
        }
    }
    public static void checkString(String s){
        if(!(s.isEmpty())){
            System.out.println("The string taken from map is : " + s);
        }else{
            System.out.println("String not found !");
        }
    }
    public static void getStringForNumber(Map<Integer, String> map , int number){
        String result= new String();
        if(map.containsKey(number)){
            result = map.get(number);
        }
        Main.checkString(result);
    }
    public static void main (String args []){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        Main.removeFirstElem(array);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("abss");
        strings.add("absadsss");
        strings.add("cccc");
        strings.add("fgsgs");
        Main.removeGivenLength(strings);

        LinkedList<Integer>list = new LinkedList<>();
        Main.insertInLinkedList(list,4,true);
        Main.insertInLinkedList(list,5,true);
        Main.insertInLinkedList(list,8,true);
        Main.insertInLinkedList(list,9,false);
        Main.forEachLinkedList(list);

        Set<Integer> set = new HashSet<>();
        set.addAll(array);
        Main.interateSet(set);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        Main.getStringForNumber(map,4);


    }
}

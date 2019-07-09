package com.msg.examples.se.secondDay;

import java.util.*;

public class Main {

        static ArrayList <Integer> array= new ArrayList<>();
        ArrayList <String> string=new ArrayList<>();
        LinkedList <Integer> linked=new LinkedList<>();

        public static void removeFirstOccurrence(int element){
                array.forEach(e -> array.remove(element));
        }

        public static void removeGivenLength(ArrayList<String> string, int length){
                for(String s : string){
                        if(s.length()==length){
                                string.remove(s);
                        }
                }
        }

        public static void insertElement(LinkedList<Integer> linked, int element, int first){
                Iterator<Integer> iterator = linked.iterator();
                while (iterator.hasNext()) {
                        element = iterator.next();
                        if(first==0) {
                                linked.addLast(element);
                        }
                        else if(first==1){
                                linked.addFirst(element);
                        }
                }

        }

        public static void main(String[] args){

                ArrayList <Integer> array= new ArrayList<>();
                ArrayList <String> string=new ArrayList<>();
                LinkedList <Integer> linked=new LinkedList<>();

                array.add(1);
                array.add(2);
                string.add("ana");
                string.add("bogdan");
                linked.add(1);
                linked.add(2);

                removeFirstOccurrence(1);
                System.out.println(array);

                removeGivenLength(string,3);
                System.out.println(string);

                //insertElement(linked,3,0);
                System.out.println(linked);


       Map <Integer,String> map = new HashMap<Integer,String>();
                map.put(1,"one");
                map.put(2,"two");
                map.put(3,"three");
                map.put(4,"four");

                System.out.println(map.get(1));
                System.out.println(map.get(2));
                System.out.println(map.get(3));
                System.out.println(map.get(4));


              }




}

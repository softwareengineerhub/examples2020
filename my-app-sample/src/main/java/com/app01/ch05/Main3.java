package com.app01.ch05;


import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {

    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add("W");
        set.add("A");
        set.add("B");
        set.add("A");
        set.add("C");
        //set.add(1);


        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println("---------------");
        for(Object item: set){
            System.out.println(item);
        }
        System.out.println("---------------");
        set.remove("B");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("B"));
        System.out.println(set.contains("A"));

    }
}

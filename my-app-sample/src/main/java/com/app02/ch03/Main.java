package com.app02.ch03;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Comparator comparator = new MyComparator();
        Set set = new TreeSet(comparator);
       // Set set = new TreeSet();

        set.add(new MyPhone(1, "Name1"));
        set.add(new MyPhone(2, "Name2"));
        set.add(new MyPhone(3, "Name3"));
        set.add(new MyPhone(0, "Name0"));
        set.add(new MyPhone(0, "AName0"));
        System.out.println(set);
    }

}

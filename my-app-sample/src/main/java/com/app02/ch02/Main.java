package com.app02.ch02;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set set = new TreeSet();
        MyDog myDog = new MyDog("Dog1", 1);
        set.add(myDog);
        set.add(new MyDog("Dog2", 2));
        set.add(new MyDog("Dog3", 3));
        set.add(new MyDog("Dog0", 0));
        set.add(new MyDog("ADog0", 0));
        System.out.println(set);
    }

}

package com.app02.ch01;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map map = new HashMap();
        MyKey myKey = new MyKey();
        myKey.setAge(1);
        myKey.setName("a");
        map.put(myKey, "A");


        myKey = new MyKey();
        myKey.setAge(2);
        myKey.setName("b");
        map.put(myKey, "B");

        myKey = new MyKey();
        myKey.setAge(1);
        myKey.setName("a");
        map.put(myKey, "C");

        System.out.println(map.size());
        System.out.println(map);


        myKey = new MyKey();
        myKey.setAge(1);
        myKey.setName("a");
        Object val = map.get(myKey);
        System.out.println("val="+val);


    }
}

package com.app01.ch05;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Map4 {

    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put("W", 10);
        map.put("A", 1);
        map.put("B", 2);
        Object oldValue = map.put("C", 1);
        System.out.println("oldVal="+oldValue);
        oldValue = map.put("C", 2);
        System.out.println("oldVal="+oldValue);
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        Object val = map.get("W");
        System.out.println("w="+val);
        boolean res = map.containsKey("w1");
        System.out.println("Res="+res);
        res = map.containsValue(10);
        System.out.println("Res="+res);

        map.remove("W");
        System.out.println(map);
        System.out.println("------------");
        Set keys = map.keySet();
        for(Object key: keys){
            System.out.println(key+"="+map.get(key));
        }

    }
}

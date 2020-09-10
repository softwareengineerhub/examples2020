package com.app02.ch04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new MyDog());
        m(list);
        for(int i=0;i<list.size();i++){
            MyDog myDog = (MyDog) list.get(i);
        }

        for(Object item: list){
            MyDog myDog = (MyDog) item;
        }
    }

    private static void m(List list){
        list.add(new MyCat());
    }

}

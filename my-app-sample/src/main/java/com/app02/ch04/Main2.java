package com.app02.ch04;

import java.util.ArrayList;
import java.util.List;

public class Main2 {


    public static void main(String[] args) {
        //Object[] data = new MyDog[10];

        List<MyDog> list = new ArrayList();
        //list.add(new MyCat());
        //list.add("");
        list.add(new MyDog());
        list.add(new MyDogChild());

        for(MyDog myDog: list){

        }

        for(int i=0;i<list.size();i++){
            MyDog myDog = list.get(i);
        }
       // m(list);
        for(int i=0;i<list.size();i++){
            MyDog myDog = list.get(i);
        }
    }

    private static void m(List list){
        list.add(new MyCat());
    }

    private static void addData(List<? super MyDog> list){
        //list.add(new MyCat());
        list.add(new MyDog());
        list.add(new MyDogChild());

    }

    private static MyDog readData(List<? extends MyDog> list){
        //list.add(new MyDog());
        return list.get(0);
    }




}

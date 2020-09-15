package com.app;

import my.simple.lib.MyData;

public class Main {

    public static void main(String[] args) {
        MyData myData = new MyData();
        myData.setAge(1);
        myData.setName("Name1");
        System.out.println(myData);
    }
}

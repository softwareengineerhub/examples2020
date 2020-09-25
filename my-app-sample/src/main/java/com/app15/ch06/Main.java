package com.app15.ch06;

public class Main {

    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
        MySingleton mySingletonB = MySingleton.getInstance();

        MySingleton mySingleton2 = MySingleton.getInstance();

        MySingleton3 mySingleton3 = MySingleton3.INSTANCE;




    }
}

package com.app05.ch04;

public class Main {

    public static void main(String[] args) {
        Thread t = new MyThreadB1();
        //t.setDaemon(true);
        t.start();
    }

}

package com.app05.ch06;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new MyThreadC1();
        Thread t2 = new MyThreadC2();
        Thread t3 = new MyThreadC3();

        t1.start();
        t2.start();
        t3.start();
    }
}

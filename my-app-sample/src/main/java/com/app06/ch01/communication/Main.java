package com.app06.ch01.communication;

public class Main {

    public static void main(String[] args) {
        int value = 0;
        Object monitor = new Object();
        //Object monitor2 = new Object();
        Thread listenerA = new ListenerA(value, monitor);
        Thread listenerB = new ListenerB(value, monitor);
        //monitor = new Object();
        Thread creator = new Creator(value, monitor);


        creator.start();
        listenerA.start();
        listenerB.start();
    }

}

package com.app05.ch02;

public class MyData {
    private int value;

    public synchronized void increment(){
        value++;
    }

    public synchronized void decrement(){
        value--;
    }

    public int getValue() {
        return value;
    }
}

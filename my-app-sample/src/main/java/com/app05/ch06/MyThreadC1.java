package com.app05.ch06;

public class MyThreadC1 extends Thread {

    public MyThreadC1() {
        setPriority(Thread.MIN_PRIORITY);
    }

    public void run(){
        for(int i=0;i<100_000;i++){
            System.out.println("@@@min="+i);
        }
    }
}

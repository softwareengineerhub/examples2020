package com.app05.ch06;

public class MyThreadC3 extends Thread {

    public MyThreadC3() {
        setPriority(Thread.MAX_PRIORITY);
    }

    public void run(){
        for(int i=0;i<100_000;i++){
            System.out.println("@@@max="+i);
        }
    }
}

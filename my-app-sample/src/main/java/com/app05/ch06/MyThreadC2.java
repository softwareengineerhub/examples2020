package com.app05.ch06;

public class MyThreadC2 extends Thread {

    public MyThreadC2() {
        setPriority(Thread.NORM_PRIORITY);
    }

    public void run(){
        for(int i=0;i<100_000;i++){
            System.out.println("!!!norm="+i);
        }
    }
}

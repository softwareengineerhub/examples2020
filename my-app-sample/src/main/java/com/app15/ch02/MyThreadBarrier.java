package com.app15.ch02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyThreadBarrier extends Thread{
    private CyclicBarrier cyclicBarrier;
    private long delay;

    public MyThreadBarrier(CyclicBarrier cyclicBarrier, String name, long delay) {
        this.cyclicBarrier=cyclicBarrier;
        setName(name);
        this.delay=delay;
    }

    public void run(){
        System.out.println("START: "+getName());
        try {
            Thread.sleep(delay);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("FINISH: "+getName());
    }
}

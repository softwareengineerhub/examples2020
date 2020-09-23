package com.app06.ch03.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyProducer extends Thread {

    private BlockingQueue blockingQueue;
    private int value;

    public MyProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        while (true){
            try {
               // System.out.println("@Before");
                blockingQueue.put(++value);
                System.out.println("Produced: "+value);
               // System.out.println("@After");
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

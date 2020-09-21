package com.app06.ch03.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyConsumer extends Thread {
    private BlockingQueue blockingQueue;

    public MyConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        while (true){
            try {
                Object value = blockingQueue.take();
                System.out.println("\tConsumed: "+value);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

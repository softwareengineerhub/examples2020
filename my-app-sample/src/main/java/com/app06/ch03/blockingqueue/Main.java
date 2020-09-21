package com.app06.ch03.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(1);
       // BlockingQueue blockingQueue = new SynchronousQueue();
        MyProducer myProducer = new MyProducer(blockingQueue);
        MyConsumer myConsumer = new MyConsumer(blockingQueue);
     //   MyConsumer myConsumer2 = new MyConsumer(blockingQueue);
      //  MyConsumer myConsumer3 = new MyConsumer(blockingQueue);

        myProducer.start();
        myConsumer.start();
    }

}

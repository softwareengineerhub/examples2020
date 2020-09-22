package com.app09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerGr1 extends Thread {
    private Lock lock;
    private Condition condition;

    public ProducerGr1(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run(){
        System.out.println("ProducerGr1. START");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProducerGr1.Sending signalAll");
        lock.lock();
        condition.signalAll();
        lock.unlock();
        System.out.println("ProducerGr1. FINISH");
    }


}

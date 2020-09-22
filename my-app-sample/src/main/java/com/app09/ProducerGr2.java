package com.app09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerGr2 extends Thread {
    private Lock lock;
    private Condition condition;

    public ProducerGr2(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run(){
        System.out.println("ProducerGr2. START");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProducerGr2.Sending signalAll");
        lock.lock();
        condition.signalAll();
        lock.unlock();
        System.out.println("ProducerGr2. FINISH");
    }


}

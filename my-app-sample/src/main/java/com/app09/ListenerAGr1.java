package com.app09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ListenerAGr1 extends Thread {
    private Lock lock;
    private Condition condition;

    public ListenerAGr1(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        System.out.println("\tListenerAGr1. START");
        try {
            Thread.sleep(1000);

            lock.lock();
            condition.await();

            System.out.println("\tListenerAGr1. FINISH");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}

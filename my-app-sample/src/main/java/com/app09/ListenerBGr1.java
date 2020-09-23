package com.app09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ListenerBGr1 extends Thread {
    private Lock lock;
    private Condition condition;

    public ListenerBGr1(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        System.out.println("\tListenerBGr1. START");
        try {
            Thread.sleep(1000);

            lock.lock();
            condition.await();

            System.out.println("\tListenerBGr1. FINISH");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}

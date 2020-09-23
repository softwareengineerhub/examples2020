package com.app08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyProducer extends Thread {
    private Lock lock;
    private Condition condition;
    private int value;
    private boolean produced;

    public MyProducer(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        while (true) {
            try {
                lock.lock();
                while (produced) {
                    condition.await();
                }
                value++;
                System.out.println("Produced: " + value);
                produced=true;
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public boolean isProduced() {
        return produced;
    }

    public int consume() {
        produced = false;
        return value;
    }


}

package com.app08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyConsumer extends Thread {
    private Lock lock;
    private Condition condition;
    private MyProducer myProducer;

    public MyConsumer(Lock lock, Condition condition, MyProducer myProducer) {
        this.lock = lock;
        this.condition = condition;
        this.myProducer = myProducer;
    }

    public void run() {
        for (; ; ) {
            try {

                lock.lock();
                while (!myProducer.isProduced()) {
                    condition.await();
                }
                Thread.sleep(2000);

                int value = myProducer.consume();
                System.out.println("\tConsumed: " + value);
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}

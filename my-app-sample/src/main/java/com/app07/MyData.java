package com.app07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyData {
    private int value;
    private Lock lock = new ReentrantLock();

    public void decrement() {
        try {
            //boolean res = lock.tryLock();
            lock.lock();
            value++;
        } finally {
            lock.unlock();
        }

    }

    public void increment() {
        try {
            lock.lock();
            value--;
        } finally {
            lock.unlock();
        }

    }

    public int getValue() {
        return value;
    }
}

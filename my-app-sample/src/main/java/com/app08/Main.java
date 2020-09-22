package com.app08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(false);
        Condition condition = lock.newCondition();

        MyProducer myProducer = new MyProducer(lock, condition);
        MyConsumer myConsumer = new MyConsumer(lock, condition, myProducer);

        myProducer.start();
        myConsumer.start();
    }
}

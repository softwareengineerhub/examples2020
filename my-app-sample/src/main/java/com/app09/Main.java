package com.app09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();

        ProducerGr1 producerGr1 = new ProducerGr1(lock, condition1);
        ListenerAGr1 listenerAGr1 = new ListenerAGr1(lock, condition1);
        ListenerBGr1 listenerBGr1 = new ListenerBGr1(lock, condition1);



        Condition condition2 = lock.newCondition();
        ProducerGr2 producerGr2 = new ProducerGr2(lock, condition2);
        ListenerAGr2 listenerAGr2 = new ListenerAGr2(lock, condition2);
        ListenerBGr2 listenerBGr2 = new ListenerBGr2(lock, condition2);


      //  producerGr1.start();
        listenerAGr1.start();
        listenerBGr1.start();


        producerGr2.start();
        listenerAGr2.start();
        listenerBGr2.start();


    }

}

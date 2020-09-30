package com.app15.ch01;

import java.util.concurrent.CountDownLatch;

public class MyThread2 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        System.out.println("-----thread2 - waiting--");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----thread2 - waiting -finish--");
    }
}

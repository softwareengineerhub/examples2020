package com.app15.ch01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyThread t1 = new MyThread(countDownLatch,"T1", 3000);
        MyThread t2 = new MyThread(countDownLatch,"T2", 2000);
        MyThread t3 = new MyThread(countDownLatch,"T3", 5000);
        MyThread2 myThread2 = new MyThread2(countDownLatch);

        t1.start();
        t2.start();
        t3.start();
        myThread2.start();

        //countDownLatch.await(10, TimeUnit.SECONDS);
        countDownLatch.await();
        System.out.println("----MAIN FINISH----");
    }

}

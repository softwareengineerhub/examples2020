package com.app15.ch01;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    private CountDownLatch countDownLatch;
    private long delay;
    //private String name;

    public MyThread(CountDownLatch countDownLatch, String name, long delay) {
        this.countDownLatch = countDownLatch;
        setName(name);
        this.delay=delay;
    }

    public void run(){
        System.out.println("START: "+getName());
        try {
            Thread.sleep(delay);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FINISH: "+getName()+"; counts left="+countDownLatch.getCount());
    }
}

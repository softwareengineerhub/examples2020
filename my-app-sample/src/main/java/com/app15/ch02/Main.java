package com.app15.ch02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        /*CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("--------AFTER barrier------");
            }
        });*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);


        MyThreadBarrier t1 = new MyThreadBarrier(cyclicBarrier, "T1", 2000);
        MyThreadBarrier t2 = new MyThreadBarrier(cyclicBarrier, "T2", 3000);
        MyThreadBarrier t3 = new MyThreadBarrier(cyclicBarrier, "T3", 10000);

        t1.start();
        t2.start();
        t3.start();

//cyclicBarrier.await();


    }

}

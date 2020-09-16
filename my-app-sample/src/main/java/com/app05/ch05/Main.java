package com.app05.ch05;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t.start();
        t2.start();

        Runnable r = t;
        Thread t3 = new Thread(t);
        t3.start();

    }

}

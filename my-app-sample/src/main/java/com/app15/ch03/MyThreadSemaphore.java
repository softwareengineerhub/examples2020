package com.app15.ch03;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MyThreadSemaphore extends Thread{
    private Semaphore semaphore;
    private long delay;

    public MyThreadSemaphore(Semaphore semaphore, String name, long delay) {
        this.semaphore=semaphore;
        setName(name);
        this.delay=delay;
    }

    public void run(){
        System.out.println("START: "+getName());
        while(true){
            try {
                semaphore.acquire();
                System.out.println("acquire: "+getName());
                Thread.sleep(delay);
                System.out.println("release: "+getName());
                semaphore.release();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}

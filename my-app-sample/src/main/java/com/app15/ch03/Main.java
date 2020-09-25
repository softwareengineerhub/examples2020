package com.app15.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        //semaphore.acquire();

        //semaphore.release();


        for(int i=0;i<10;i++){
        new MyThreadSemaphore(semaphore, "Name"+i, 3000).start();
        }

    }
}

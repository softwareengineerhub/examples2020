package com.app14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<100;i++){
            Thread.sleep(4000);
            executorService.submit(new MyTask(""+i));
        }


    }
}

package com.app11.ch01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        MyCallable myCallable = new MyCallable();
        Future<String> future = executorService.submit(myCallable);
        System.out.println("Next line");
        //future.cancel(false);

        while(!future.isDone()){
            System.out.println(future.isDone());
        }
        //future.isDone();
        Object resData =future.get();
        System.out.println("res="+resData);


        //executorService.shutdown();
        //executorService.submit(new MyCallable());

        //executorService.shutdownNow();
    }

}

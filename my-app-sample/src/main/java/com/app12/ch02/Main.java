package com.app12.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int[] data = {0,1,2,3,4,5,6,7,8,9};

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        SumCalculationCallable task1 = new SumCalculationCallable(new int[]{data[0], data[1], data[2]});
        SumCalculationCallable task2 = new SumCalculationCallable(new int[]{data[3], data[4], data[5]});
        SumCalculationCallable task3 = new SumCalculationCallable(new int[]{data[6], data[7], data[8]});
        SumCalculationCallable task4 = new SumCalculationCallable(new int[]{data[9]});

        Future<Integer> res1 = executorService.submit(task1);
        Future<Integer> res2 = executorService.submit(task2);
        Future<Integer> res3 = executorService.submit(task3);
        Future<Integer> res4 = executorService.submit(task4);
        List<Future<Integer>> list = new ArrayList<>();
        list.add(res1);
        list.add(res2);
        list.add(res3);
        list.add(res4);
        int sum = 0;
        for(Future<Integer> future: list){
            sum+=future.get();
        }
        System.out.println("sum="+sum);
        System.out.println("time: "+(System.currentTimeMillis()-start));


    }
}

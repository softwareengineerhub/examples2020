package com.app12.ch02;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SumCalculationCallable implements Callable<Integer> {
    private int[] subdata;

    public SumCalculationCallable(int[] subdata) {
        this.subdata = subdata;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task started: "+ Arrays.toString(subdata));
        int sum = 0;
        for(int i=0;i<subdata.length;i++){
            sum+=subdata[i];
        }
        Thread.sleep(5000);
        System.out.println("Task finished: "+ Arrays.toString(subdata));
        return sum;
    }
}

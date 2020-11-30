package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsEx {

    //сложить числа в несколько потоков
    private static class Calc implements Callable<Double> {

        final double[] a;
        final int firstIndex;
        final int lastIndex;

        public Calc(double[] a, int firstIndex, int lastIndex) {
            this.a = a;
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;
        }

        @Override
        public Double call() {
            double result = 0.0;
            for (int i = firstIndex; i <= lastIndex; i++)
                result += a[i];
            return result;
        }
    }


    public double addMachine(double[] a, int threads) {
        int chunkSize = a.length / threads;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            int leftIndex = i * chunkSize;
            int rightIndex = i + 1 == threads ? a.length - 1 : (i + 1) * chunkSize - 1;
            futures.add(executor.submit(new Calc(a, leftIndex, rightIndex)));
        }

        double result = 0.0;
        for (Future<Double> chunkResult : futures) {
            try {
                result += chunkResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

package com.app15.ch04;

import java.util.concurrent.ForkJoinPool;

public class Main2 {

    public static void main(String[] args) {
        //ExecutorService executorService = ForkJoinPool.commonPool();
        //ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        //ForkJoinPool.commonPool();
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(20, "");
        forkJoinPool.invoke(myRecursiveAction);

        /*forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println("action");
            }
        });

        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println("action");
            }
        });*/

       //forkJoinPool.submit(myRecursiveAction);

        System.out.println("------MAIN FINISH----");
    }
}

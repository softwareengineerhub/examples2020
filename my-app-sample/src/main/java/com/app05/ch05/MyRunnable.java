package com.app05.ch05;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("step #"+i+"; hashCode="+hashCode());
            System.out.println("\t"+Thread.currentThread());
            Thread t = Thread.currentThread();
            System.out.println("\t\tname="+t.getName());
            System.out.println("\t\tid="+t.getId());
            System.out.println("\t\tpriority="+t.getPriority());
            System.out.println("\t\tstate="+t.getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.app06.ch02.prod.consumer;

public class Producer extends Thread {
    private int value;
    private Object monitor;
    private boolean produced;

    public Producer(Object monitor) {
        this.monitor = monitor;
    }

    public void run(){
        while(true){

            synchronized (monitor){
                while(produced){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (monitor){
                value++;
                System.out.println("Produced: "+value);
                produced = true;
                monitor.notify();
            }

        }
    }

    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced = false;
        return value;
    }

}

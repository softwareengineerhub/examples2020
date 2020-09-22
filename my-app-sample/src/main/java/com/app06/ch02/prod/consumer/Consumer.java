package com.app06.ch02.prod.consumer;

public class Consumer extends Thread {
    private Object monitor;
    private Producer producer;

    public Consumer(Object monitor, Producer producer) {
        this.monitor = monitor;
        this.producer = producer;
    }

    public void run(){
        while(true){
            synchronized (monitor){
                while(!producer.isProduced()){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (monitor){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = producer.consume();
                System.out.println("\tConsumed: "+value);
                monitor.notify();
            }
        }
    }
}

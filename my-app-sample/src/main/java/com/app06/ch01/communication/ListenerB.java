package com.app06.ch01.communication;

public class ListenerB extends Thread {
    private int value;
    private Object monitor;

    public ListenerB(int value, Object monitor) {
        this.value = value;
        this.monitor=monitor;
    }

    public void run(){
        System.out.println("ListenerB. started");
        try {
            Thread.sleep(1000);
            synchronized (monitor) {
                if(value==0) {
                    monitor.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ListenerB. finish");

    }
}

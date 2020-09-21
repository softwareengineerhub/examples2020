package com.app06.ch01.communication;

public class ListenerA extends Thread {
    private int value;
    private Object monitor;

    public ListenerA(int value, Object monitor) {
        this.value = value;
        this.monitor=monitor;
    }

    public void run(){
        System.out.println("ListenerA. started");
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
        System.out.println("ListenerA. finish");

    }
}

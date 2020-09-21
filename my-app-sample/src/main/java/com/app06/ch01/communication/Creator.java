package com.app06.ch01.communication;

public class Creator extends Thread {
    private int value;
    private Object monitor;

    public Creator(int value, Object monitor) {
        this.value = value;
        this.monitor=monitor;
    }

    public void run(){
        try {
            System.out.println("Creator. START");
            Thread.sleep(5000);
            value++;
            synchronized (monitor){
                monitor.notifyAll();
            }
            System.out.println("Creator. FINISH");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

package com.app05.ch04;

public class MyThreadB1 extends Thread {

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("step #"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

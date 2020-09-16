package com.app05.ch01;

public class MyThreadA extends Thread {
    private MyProcessor myProcessor;

    public MyThreadA(MyProcessor myProcessor) {
        this.myProcessor = myProcessor;
    }

    public void run(){
        myProcessor.doAction1();
    }

}

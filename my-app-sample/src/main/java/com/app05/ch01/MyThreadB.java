package com.app05.ch01;

public class MyThreadB extends Thread {
    private MyProcessor myProcessor;

    public MyThreadB(MyProcessor myProcessor) {
        this.myProcessor = myProcessor;
    }

    public void run(){
        myProcessor.doAction2();
    }

}

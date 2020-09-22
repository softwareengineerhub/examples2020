package com.app07;

public class MyIncrementT extends Thread {

    private MyData myData;

    public MyIncrementT(MyData myData) {
        this.myData = myData;
    }

    public void run(){
        for(int i=0;i<100_000;i++){
            myData.increment();
        }
    }
}

package com.app07;

public class MyDecrementT extends Thread {

    private MyData myData;

    public MyDecrementT(MyData myData) {
        this.myData = myData;
    }

    public void run(){
        for(int i=0;i<100_000;i++){
            myData.decrement();
        }
    }
}

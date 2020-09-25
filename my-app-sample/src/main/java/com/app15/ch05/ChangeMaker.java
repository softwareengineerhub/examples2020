package com.app15.ch05;

public class ChangeMaker extends Thread {
    private MyData myData;

    public ChangeMaker(MyData myData) {
        this.myData = myData;
    }

    public void run(){
        for(int i=0;i<6;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.value++;
            System.out.println("Make: "+myData.value);
        }
        System.out.println("Maker-Finish");
    }
}

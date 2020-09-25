package com.app15.ch05;

public class ChangeListener extends Thread {
    private MyData myData;

    public ChangeListener(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        int tmpValue = myData.value;
        while(tmpValue<5){
            //System.out.println("\ttmpValue="+tmpValue);
            if(tmpValue!=myData.value){
                System.out.println("Change detected "+myData.value);
                tmpValue = myData.value;
            }
        }
        System.out.println("Finish: "+myData.value);
    }
}

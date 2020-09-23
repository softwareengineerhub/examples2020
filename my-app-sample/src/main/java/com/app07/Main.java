package com.app07;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        MyIncrementT t1 = new MyIncrementT(myData);
        MyDecrementT t2 = new MyDecrementT(myData);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(myData.getValue());
    }


}

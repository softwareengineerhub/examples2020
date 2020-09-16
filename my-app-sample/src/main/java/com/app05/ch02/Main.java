package com.app05.ch02;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        Thread d = new DecrementThread(myData);
        Thread i = new IncrementThread(myData);
        d.start();
        i.start();

        d.join();
        i.join();

        System.out.println("value="+myData.getValue());
    }

}

package com.app05.ch03;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String name = "A";
        String secondName= "B";
        Thread thread = new MyThreadA1(name, secondName);
        Thread thread2 = new MyThreadA1(secondName, name);

        thread.start();
        thread2.start();

        //thread.join();

    }

}

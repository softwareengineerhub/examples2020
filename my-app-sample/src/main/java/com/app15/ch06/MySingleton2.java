package com.app15.ch06;

public class MySingleton2 {
    private static MySingleton2 instance = new MySingleton2();

    private MySingleton2() {

    }

    public synchronized void m() {

    }

    public void m2() {
        synchronized (this) {

        }
    }

    public static synchronized void m3(){

    }

    public static void m4(){
        synchronized (MySingleton2.class){

        }
    }


    public static synchronized MySingleton2 getInstance() {
        return instance;
    }

}

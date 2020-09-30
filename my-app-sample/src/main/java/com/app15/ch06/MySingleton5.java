package com.app15.ch06;

public class MySingleton5 {
    private static volatile MySingleton5 instance;

    private MySingleton5(){

    }

    public static MySingleton5 getInstance(){
        if(instance == null){
            synchronized (MySingleton5.class) {
                if(instance == null) {
                    instance = new MySingleton5();
                }
            }
        }
        return instance;
    }

}

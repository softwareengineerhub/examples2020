package com.app15.ch06;

public class MySingleton4 {
    private static MySingleton4 instance;

    private MySingleton4(){

    }

    public static synchronized MySingleton4 getInstance(){
        if(instance == null){
            instance = new MySingleton4();
        }
        return instance;
    }

}

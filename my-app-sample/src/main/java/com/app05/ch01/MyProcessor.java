package com.app05.ch01;

public class MyProcessor {


    public void doAction1(){
        long start = System.currentTimeMillis();
        System.out.println("@START. doAction1");
        while(System.currentTimeMillis()-start<=5000){
        }
        System.out.println("@FINISH. doAction1");
    }


    public void doAction2(){
        long start = System.currentTimeMillis();
        System.out.println("@START. doAction2");
        while(System.currentTimeMillis()-start<=10000){
        }
        System.out.println("@FINISH. doAction2");
    }




}

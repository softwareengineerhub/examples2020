package com.app05.ch03;

public class MyThreadA1 extends Thread {
    private String name;
    private String secondName;

    public MyThreadA1(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public void run(){
        synchronized (name){
            try {
                Thread.sleep(1000);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            System.out.println("inside: "+name);
            synchronized (secondName){
                System.out.println("\tinside: "+secondName);
            }

        }
    }
}

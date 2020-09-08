package com.app.ch08;

public abstract class Data8 {

    public abstract void m();

    public void doAction(){
        System.out.println("@Start");
        m();
        System.out.println("@End");
    }

}

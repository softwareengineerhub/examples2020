package com.app.ch04;

public class Child4 extends  Parent4{

    public void doAction(){
        super.doAction();
        System.out.println("Child.doAction()");
        super.doAction();
    }
}

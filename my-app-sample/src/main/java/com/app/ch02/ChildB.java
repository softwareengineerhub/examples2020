package com.app.ch02;

public class ChildB extends ChildA {
    public int i=2;

    public void doAction(){
        System.out.println("this is childB");
    }

    public int doAction(String param){
        System.out.println("this is childB: param="+param);
        return 1;
    }

}

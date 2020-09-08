package com.ch01.app03;


public class Main {

    public static void main(String[] args) {
        MyComposition myComposition = new MyComposition();
        int res = myComposition.calculateN("ABCD");
        System.out.println("res="+res);
        System.out.println("---------------");
        MyBusinessProcessor myBusinessProcessor = new MyChildBP();
        res = myBusinessProcessor.processData("ABCD");
        System.out.println("res="+res);
    }
}

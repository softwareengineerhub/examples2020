package com.ch01.app01;

public class Parent {

    static {
        System.out.println("Parent. static{}");
    }


    {
        System.out.println("Parent. init1{}");
    }

    public Parent(){
        System.out.println("Parent.constructor");
    }

    {
        System.out.println("Parent. init2{}");
    }

}

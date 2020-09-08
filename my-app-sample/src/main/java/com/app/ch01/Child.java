package com.app.ch01;

public class Child extends Parent {

    static{
        System.out.println("\t\tChild static{} init");
    }

    {
        System.out.println("\t\tChild init1");
    }

    public Child(){
        System.out.println("\t\tChild constructor");
    }

    {
        System.out.println("\t\tChild init2");
    }
}

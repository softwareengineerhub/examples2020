package com.ch01.app01;

public class Child extends Parent {

    static {
        System.out.println("\tChild. static{}");
    }


    {
        System.out.println("\tChild. init1{}");
    }

    public Child(){
        System.out.println("\tChild.constructor");
    }

    {
        System.out.println("\tChild. init2{}");
    }

}

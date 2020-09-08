package com.app.ch01;

public class Parent extends GrantParent {

    static{
        System.out.println("\tParent static{} init");
    }

    {
        System.out.println("\tParent init1");
    }


    public Parent(){
        System.out.println("\tParent constructor");
    }

    {
        System.out.println("\tParent init2");
    }
}

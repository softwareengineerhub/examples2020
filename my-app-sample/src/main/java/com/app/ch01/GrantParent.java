package com.app.ch01;

public class GrantParent {

    static{
        System.out.println("GrantParent static{} init");
    }

    {
        System.out.println("GrantParent init1");
    }

    public GrantParent(){
        System.out.println("GrantParent constructor");
    }


    {
        System.out.println("GrantParent init2");
    }
}

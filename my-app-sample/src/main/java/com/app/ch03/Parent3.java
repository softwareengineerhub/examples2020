package com.app.ch03;

public class Parent3 {


    public Parent3(){
        this("Denis");
        System.out.println("Parent().Constructor");
    }

    public Parent3(String name){
        System.out.println("Parent(name).Constructor; name="+name);
    }

}

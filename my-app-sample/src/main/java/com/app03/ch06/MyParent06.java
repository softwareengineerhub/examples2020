package com.app03.ch06;

import java.io.Serializable;

public class MyParent06 {
    private String name;

    public MyParent06(){
        System.out.println("Parent.constructor()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyParent06{" +
                "name='" + name + '\'' +
                '}';
    }
}

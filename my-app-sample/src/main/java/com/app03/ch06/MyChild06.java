package com.app03.ch06;

import java.io.Serializable;

public class MyChild06 extends  MyParent06  implements Serializable {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString()+"; age="+age;
    }
}

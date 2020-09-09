package com.app01.ch03;

/*
Immutable - объект, чье состояние нельзя изменить после создания.
Сосотояние обьекта - это значение его полей.

String
Integer
Float
Maths

 */

import java.util.Arrays;

public class MyImmutableData2 {
    private final String name;
    private final int age;
    private final int[] data;

    public MyImmutableData2(String name, int age, int[] data) {
        this.name = name;
        this.age = age;
        this.data = new int[data.length];
        for(int i=0;i<data.length;i++){
            this.data[i] = data[i];
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getData() {
        return Arrays.copyOf(data, data.length);
        //return data;
    }
}

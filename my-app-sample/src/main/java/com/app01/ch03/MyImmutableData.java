package com.app01.ch03;

/*
Immutable - объект, чье состояние нельзя изменить после создания.
Сосотояние обьекта - это значение его полей.

String
Integer
Float
Math
s

 */

public class MyImmutableData {
    private final String name;
    private final int age;

    public MyImmutableData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

package com.app03.ch02;

public class MyUser {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

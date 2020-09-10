package com.app02.ch03;

public class MyPhone implements Comparable {
    private int age;
    private String name;

    public MyPhone(int age, String name) {
        this.age = age;
        this.name = name;
    }

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
        return "MyPhone{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        MyPhone myPhone = (MyPhone) o;

        return (age-(myPhone.age));
    }
}

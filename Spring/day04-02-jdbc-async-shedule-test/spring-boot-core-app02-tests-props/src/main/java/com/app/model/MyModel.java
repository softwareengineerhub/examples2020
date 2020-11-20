package com.app.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyModel {
    @Value("${app.name}")
    private String name;
    @Value("${app.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

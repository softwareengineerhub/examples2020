package com.app.dto;

import javax.validation.constraints.Min;

public class PersonDto {


    private String name;
    @Min(value = 10)
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
}

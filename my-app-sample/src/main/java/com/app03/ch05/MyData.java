package com.app03.ch05;

public class MyData {
    private String description;

    public MyData(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "description='" + description + '\'' +
                '}';
    }
}

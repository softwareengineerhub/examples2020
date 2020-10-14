package com.app.model;

import java.io.Serializable;

public class Cap implements Serializable {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Cap{" +
                "title='" + title + '\'' +
                '}';
    }
}

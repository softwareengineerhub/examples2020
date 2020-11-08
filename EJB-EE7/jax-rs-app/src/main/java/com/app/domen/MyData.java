package com.app.domen;

import javax.validation.constraints.Max;

public class MyData {

    @Max(value = 20)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

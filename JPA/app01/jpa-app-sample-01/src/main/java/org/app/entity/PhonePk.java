package org.app.entity;

import java.io.Serializable;

public class PhonePk implements Serializable {
    private int year;
    private int price;

    public PhonePk(int year, int price) {
        this.year = year;
        this.price = price;
    }

    public PhonePk() {
    }
}

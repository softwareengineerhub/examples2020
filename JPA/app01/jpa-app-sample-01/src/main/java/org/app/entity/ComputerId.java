package org.app.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ComputerId {

    private int price;
    private int year;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ComputerId{" +
                "price=" + price +
                ", year=" + year +
                '}';
    }
}

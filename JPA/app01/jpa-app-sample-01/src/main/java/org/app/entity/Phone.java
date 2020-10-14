package org.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PhonePk.class)
public class Phone {

    @Id
    private int year;
    @Id
    private int price;

    private String title;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "year=" + year +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}

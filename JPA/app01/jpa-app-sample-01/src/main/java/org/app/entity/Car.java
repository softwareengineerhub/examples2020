package org.app.entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Embedded
    private CarDescription carDescription;
    //@Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private ColorData colorData;

    public ColorData getColorData() {
        return colorData;
    }

    public void setColorData(ColorData colorData) {
        this.colorData = colorData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarDescription getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(CarDescription carDescription) {
        this.carDescription = carDescription;
    }
}

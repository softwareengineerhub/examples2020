package org.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Computer {

    @EmbeddedId
    private ComputerId computerId;
    private String name;

    public ComputerId getComputerId() {
        return computerId;
    }

    public void setComputerId(ComputerId computerId) {
        this.computerId = computerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerId=" + computerId +
                ", name='" + name + '\'' +
                '}';
    }
}

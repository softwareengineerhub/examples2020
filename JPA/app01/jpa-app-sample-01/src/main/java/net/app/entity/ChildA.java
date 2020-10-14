package net.app.entity;

import javax.persistence.Entity;

@Entity
public class ChildA extends Parent {
    private String titleA;

    public String getTitleA() {
        return titleA;
    }

    public void setTitleA(String titleA) {
        this.titleA = titleA;
    }
}

package net.app.entity;

import javax.persistence.Entity;

@Entity
public class ChildB extends Parent {
    private String titleB;

    public String getTitleB() {
        return titleB;
    }

    public void setTitleB(String titleB) {
        this.titleB = titleB;
    }
}

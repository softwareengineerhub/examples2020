package ch06.app.entity;

import ch05.app.entity.Shop;

import javax.persistence.*;
import java.util.List;

@Entity
public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany(mappedBy = "listA")
    private List<B> listB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<B> getListB() {
        return listB;
    }

    public void setListB(List<B> listB) {
        this.listB = listB;
    }
}

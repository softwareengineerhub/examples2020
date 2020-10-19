package ch06.app.entity;

import ch05.app.entity.Shop;

import javax.persistence.*;
import java.util.List;

@Entity
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany
    private List<A> listA;

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

    public List<A> getListA() {
        return listA;
    }

    public void setListA(List<A> listA) {
        this.listA = listA;
    }
}

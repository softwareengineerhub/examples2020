package ch02.app.entity;

import javax.persistence.*;
import java.util.ListIterator;

@Entity
@EntityListeners({ListenerA.class, ListenerB.class, ListenerC.class, ListenerD.class, ListenerE.class})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostLoad
    public void afterSelect(){
        System.out.println("@PostLoad");
    }
}

package ch07.app.entity;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @ManyToOne
    private MyEmployee myEmployee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MyEmployee getMyEmployee() {
        return myEmployee;
    }

    public void setMyEmployee(MyEmployee myEmployee) {
        this.myEmployee = myEmployee;
    }
}

package ch07.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class MyCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<MyEmployee> employeeList;

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

    public List<MyEmployee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<MyEmployee> employeeList) {
        this.employeeList = employeeList;
    }
}

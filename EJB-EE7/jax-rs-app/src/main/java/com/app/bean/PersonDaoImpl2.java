package com.app.bean;

import com.app.domen.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PersonDaoImpl2 implements PersonDao {
    private List<Person> persons;

    @PostConstruct
    public void init(){
        persons = new ArrayList<>();
    }

    @Override
    public void create(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int id) {
        return persons.get(id);
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public void update(int id, Person person) {
        persons.set(id, person);
    }

    @Override
    public void deleteById(int id) {
        persons.remove(id);
    }

    @Override
    public void deleteAll() {
        persons.clear();
    }
}

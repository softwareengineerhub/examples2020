package com.app.dao;

import com.app.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao  {
    private List<Person> persons = new ArrayList();

    public void init(){
        System.out.println("DaoImpl.init()");
    }

    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> readAll() {
        return persons;
    }

    public void destroy(){
        System.out.println("DaoImpl.destroy()");
    }
}

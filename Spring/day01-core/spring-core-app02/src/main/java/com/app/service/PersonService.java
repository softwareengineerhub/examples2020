package com.app.service;

import com.app.dao.Dao;
import com.app.model.Person;

import java.util.List;

public class PersonService {
    private Dao dao;

    public void createPerson(Person person){
        dao.save(person);
    }

    public List<Person> readAll(){
        return dao.readAll();
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}

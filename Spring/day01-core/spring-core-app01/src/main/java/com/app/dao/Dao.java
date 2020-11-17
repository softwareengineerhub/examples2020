package com.app.dao;

import com.app.model.Person;

import java.util.List;

public interface Dao {

    public void save(Person person);

    public List<Person> readAll();


}

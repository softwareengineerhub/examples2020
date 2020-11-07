package com.app.bean;


import com.app.domen.Person;

import java.util.List;

public interface PersonDao {

    public void create(Person person);

    public Person findById(int id);

    public List<Person> findAll();

    public void update(int id, Person person);

    public void deleteById(int id);

    public void deleteAll();


}

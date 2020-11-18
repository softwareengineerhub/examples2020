package com.app.repo;

import com.app.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepo {

    private List<Person> persons;

    @PostConstruct
    public void init(){
        persons = new ArrayList<>();
    }

    public void create(Person person){
        persons.add(person);
    }

    public List<Person> readAll(){
        return persons;
    }

    public Person readById(int id){
        return persons.get(id);
    }

    public void update(int id, Person candidate){
        persons.set(id, candidate);
    }

    public void deleteById(int id){
        persons.remove(id);
    }

    public void deleteAll(){
        persons.clear();
    }






}

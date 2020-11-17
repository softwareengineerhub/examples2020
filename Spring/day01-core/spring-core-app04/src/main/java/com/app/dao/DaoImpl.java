package com.app.dao;

import com.app.model.Person;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao  {

    private List<Person> persons = new ArrayList();


    public void initD(){
        System.out.println("DaoImpl.init()");
    }

    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> readAll() {
        return persons;
    }

    public void destroyD(){
        System.out.println("DaoImpl.destroy()");
    }
}

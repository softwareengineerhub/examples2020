package com.app.repository;

import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;

    public void create(Person person){
        entityManager.persist(person);
    }

}

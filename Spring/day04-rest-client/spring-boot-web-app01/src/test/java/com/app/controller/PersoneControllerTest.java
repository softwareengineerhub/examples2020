package com.app.controller;

import com.app.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersoneControllerTest {

    @Autowired
    private PersonRestClient personClient;

    @Test
    public void crudTest(){
        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        personClient.create(person);


        List<Person> persons = personClient.findAll();
        assertTrue(persons.size()==1);

        Person personById = personClient.findById(0);
        assertTrue(same(personById, persons.get(0)));
        assertTrue(same(personById, person));


        Person candidate = new Person();
        candidate.setAge(22);
        candidate.setName("Name-Update");
        personClient.update(0, candidate);

        persons = personClient.findAll();
        assertTrue(persons.size()==1);


        personById = personClient.findById(0);
        assertTrue(same(personById, candidate));


        personClient.create(person);
        personClient.create(person);
        persons = personClient.findAll();
        assertTrue(persons.size()==3);


        personClient.deleteById(0);
        persons = personClient.findAll();
        assertTrue(persons.size()==2);

        personClient.deleteAll();
        persons = personClient.findAll();
        assertTrue(persons.isEmpty());
    }


    private boolean same(Person a, Person b){
        if(a.getAge()==b.getAge()){
            if(a.getName()==null && b.getName()==null){
                return true;
            }
            if(a.getName()!=null){
                return a.getName().equals(b.getName());
            }
            if(b.getName()!=null){
                return b.getName().equals(a.getName());
            }
        }
        return false;
    }



}

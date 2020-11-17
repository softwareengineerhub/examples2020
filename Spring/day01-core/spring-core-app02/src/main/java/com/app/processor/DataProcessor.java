package com.app.processor;

import com.app.model.Person;
import com.app.service.PersonService;

import java.util.List;

public class DataProcessor {

    private PersonService personService;

    public List<Person> doAction(int age, String name){
        personService.createPerson(new Person(name, age));
        return personService.readAll();
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}

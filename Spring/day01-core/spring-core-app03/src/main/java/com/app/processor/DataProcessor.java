package com.app.processor;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataProcessor {

    @Autowired
    private PersonService personService;

    public List<Person> doAction(int age, String name){
        personService.createPerson(new Person(name, age));
        return personService.readAll();
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}

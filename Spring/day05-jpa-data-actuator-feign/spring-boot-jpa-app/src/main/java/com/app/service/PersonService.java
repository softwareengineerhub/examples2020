package com.app.service;

import com.app.model.Person;
import com.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void create(Person person){
        personRepository.create(person);
    }
}

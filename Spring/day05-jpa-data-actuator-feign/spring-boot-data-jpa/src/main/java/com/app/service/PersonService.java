package com.app.service;

import com.app.model.Person;
import com.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void create(Person person){
        personRepository.save(person);
    }

    public List<Person> findAllByName(String name){
        return personRepository.findAllByName(name);
    }


    public List<Person> findAllByNameAndAge(String name, int age){
        return personRepository.findAllByNameAndAge(name, age);
    }

    public long nativeCount(String name, int age){
        return personRepository.nativeCount(name, age);
    }

    public long jpaCount(String name, int age){
        return personRepository.jpaCount(name, age);
    }

    public void nativeRemoveByNameAndAge(String name, int age){
        personRepository.nativeRemoveByNameAndAge(name, age);
    }


    public void jpaRemoveByNameAndAge(String name, int age){
        personRepository.jpaRemoveByNameAndAge(name, age);
    }


    public List<Person> findAll(Pageable pageable){
        Page<Person> result =  personRepository.findAll(pageable);
        return result.getContent();
    }
}

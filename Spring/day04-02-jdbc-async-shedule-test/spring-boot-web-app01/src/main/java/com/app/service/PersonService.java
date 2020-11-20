package com.app.service;

import com.app.model.Person;
import com.app.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public void create(Person person) {
        personRepo.create(person);
    }

    public List<Person> readAll() {
        return personRepo.readAll();
    }

    public Person readById(int id) {
        return personRepo.readById(id);
    }

    public void update(int id, Person candidate) {
        personRepo.update(id, candidate);
    }

    public void deleteById(int id) {
        personRepo.deleteById(id);
    }

    public void deleteAll() {
        personRepo.deleteAll();
    }

}

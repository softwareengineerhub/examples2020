package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/person")
public class PersonController3 {
    @Autowired
    private PersonService personService;


    @PostMapping
    public void creat(@RequestBody Person person) {
        personService.create(person);
    }

    @GetMapping
    public List<Person> readAll() {
        return personService.readAll();
    }

    @GetMapping("/{id}")
    public Person readById(@PathVariable(name = "id") int id) {
        return personService.readById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Person candidate) {
        personService.update(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        personService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        personService.deleteAll();
    }


}

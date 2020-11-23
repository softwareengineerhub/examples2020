package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public void create(@RequestBody  Person person){
        personService.create(person);
    }

    /*@GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }*/

    @GetMapping
    public List<Person> findAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size){
        if(page==null || size==null){
            return personService.findAll();
        }
        Pageable pageable = PageRequest.of(page, size);
        return personService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable int id){
        return personService.findById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Person candidate){
        personService.update(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        personService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        personService.deleteAll();
    }



}

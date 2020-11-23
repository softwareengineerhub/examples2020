package com.app.controller;

import com.app.dto.PersonDto;
import com.app.model.Person;
import com.app.service.PersonService;
import com.app.service.PersonService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person2")
public class PersonController2 {

    @Autowired
    private PersonService2 personService2;

    @PostMapping
    public void create(@Valid  @RequestBody PersonDto person){
        personService2.create(person);
    }


    @GetMapping
    public List<PersonDto> findAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size){
        if(page==null || size==null){
            return personService2.findAll();
        }
        Pageable pageable = PageRequest.of(page, size);
        return personService2.findAll(pageable);
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable int id){
        return personService2.findById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PersonDto candidate){
        personService2.update(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        personService2.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        personService2.deleteAll();
    }



}

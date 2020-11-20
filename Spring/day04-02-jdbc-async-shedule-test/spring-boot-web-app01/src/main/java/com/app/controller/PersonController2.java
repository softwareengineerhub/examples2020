package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/v2/person")
public class PersonController2 {
    @Autowired
    private PersonService personService;


    @RequestMapping(method = RequestMethod.POST)
    public void creat(@RequestBody Person person) {
        personService.create(person);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> readAll() {
        return personService.readAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Person readById(@PathVariable(name = "id") int id) {
        return personService.readById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@PathVariable int id, @RequestBody Person candidate) {
        personService.update(id, candidate);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable int id) {
        personService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll() {
        personService.deleteAll();
    }


}

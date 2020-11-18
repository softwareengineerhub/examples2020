package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@ResponseBody
public class PersonController {
    @Autowired
    private PersonService personService;


    @RequestMapping(method = RequestMethod.POST, value = "/v1/person")
    public void creat(@RequestBody Person person) {
        personService.create(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/person")
    public List<Person> readAll() {
        return personService.readAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/person/{id}")
    public Person readById(@PathVariable(name = "id") int id) {
        return personService.readById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/person/{id}")
    public void update(@PathVariable int id, @RequestBody Person candidate) {
        personService.update(id, candidate);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/v1/person/{id}")
    public void deleteById(@PathVariable int id) {
        personService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/v1/person")
    public void deleteAll() {
        personService.deleteAll();
    }


}

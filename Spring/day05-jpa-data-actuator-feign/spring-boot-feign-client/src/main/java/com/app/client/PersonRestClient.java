package com.app.client;

import com.app.model.PersonDto;
import feign.Headers;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface PersonRestClient {


    @PostMapping(value = "/person2")
    //@Headers("Content-Type: application/json")
    public Response create(PersonDto person);


    @GetMapping("/person2/{id}")
    public PersonDto findById(@PathVariable int id);

    @GetMapping("/person2")
    public List<PersonDto> findAll();

    //@GetMapping("/persons/{id}")
    //public Person findById2(@PathVariable("id") int id);



}

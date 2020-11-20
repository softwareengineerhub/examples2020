package com.app.controller;

import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PersonRestClient {

    @Autowired
    private TestRestTemplate restTemplate;
    private String url="/v3/person";


    public PersonRestClient() {
    }

    public void create(Person person){
        ResponseEntity responseEntity = restTemplate.postForEntity(url, person, ResponseEntity.class);
        int responseCode = responseEntity.getStatusCodeValue();
        System.out.println("responsecode="+responseCode);
    }



    public List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List list = responseEntity.getBody();
        for(Object item: list){
            Map map = (Map) item;
            String name = map.get("name")+"";
            int age = Integer.parseInt(map.get("age")+"");
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            personList.add(person);
        }

        return personList;
    }

    public Person findById(int id){
        Person person = restTemplate.getForObject(url+"/"+id, Person.class);
        return person;
    }

    public void update(int id, Person candidate){
        restTemplate.put(url+"/"+id, candidate);
    }


    public void deleteById(int id){
        restTemplate.delete(url+"/"+id);
    }

    public void deleteAll(){
        restTemplate.delete(url);
    }



}

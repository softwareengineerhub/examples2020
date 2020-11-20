package com.app.client;

import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PersonClient {

    //@Autowired
    //private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RestTemplate restTemplate;
    @Value("${rest.url}")
    private String url;


    public void create(Person person){
        ResponseEntity responseEntity = restTemplate.postForEntity(url, person, ResponseEntity.class);
        int responseCode = responseEntity.getStatusCodeValue();
        System.out.println("responsecode="+responseCode);
    }



    public List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List list = responseEntity.getBody();
        System.out.println("###############"+list.getClass());
        for(Object item: list){
            Map map = (Map) item;
            String name = map.get("name")+"";
            int age = Integer.parseInt(map.get("age")+"");
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            personList.add(person);
        }
        System.out.println(list.get(0).getClass());
        System.out.println("###############");
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

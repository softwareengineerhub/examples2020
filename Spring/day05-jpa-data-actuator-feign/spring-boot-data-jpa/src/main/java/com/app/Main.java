package com.app;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("Name2");
        person.setAge(2);
        personService.create(person);

        List<Person> persons =  personService.findAllByName("Name1");
        for(Person p: persons){
            System.out.println(p);
        }


        System.out.println("------------");
        persons =  personService.findAllByNameAndAge("Name2", 2);
        for(Person p: persons){
            System.out.println(p);
        }

        System.out.println("--------count - native------------");
        System.out.println(personService.nativeCount("Name2", 2));

        System.out.println("--------count - jpa------------");
        System.out.println(personService.jpaCount("Name2", 2));

        System.out.println("--------remove - native------------");
        personService.nativeRemoveByNameAndAge("Name1", 1);

        System.out.println("--------remove - jpa------------");
        personService.jpaRemoveByNameAndAge("Name2", 2);

        System.out.println("--------find with with pageable---------");
        for(int i=10;i<20;i++){
            Person p = new Person();
            p.setAge(i);
            p.setName("Name"+i);
        //    personService.create(p);
        }

        Pageable pageable = PageRequest.of(30, 3);
        persons = personService.findAll(pageable);
        for(Person p: persons){
            System.out.println(p);
        }

    }
}

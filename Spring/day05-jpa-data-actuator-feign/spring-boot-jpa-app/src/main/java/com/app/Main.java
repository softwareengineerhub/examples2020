package com.app;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        person.setName("Name1");
        person.setAge(1);
        personService.create(person);
    }
}

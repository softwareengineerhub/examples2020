package com.app;

import com.app.client.PersonClient;
import com.app.model.Person;
import com.app.model.PersonsBulk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private PersonClient personClient;

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("1) create()");
        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        personClient.create(person);
        System.out.println("----------------");

        System.out.println("2) findAll");
        List<Person> persons = personClient.findAll();
        for(Person p: persons){
            System.out.println(p);
        }
        System.out.println("----------------");

        System.out.println("3) findById");
        person = personClient.findById(0);
        System.out.println(person);
        System.out.println("----------------");

        System.out.println("4) update");
        Person candidate = new Person();
        candidate.setAge(22);
        candidate.setName("Name-Update");
        personClient.update(0, candidate);
        System.out.println(person);
        person = personClient.findById(0);
        System.out.println(person);
        System.out.println("----------------");

        //System.out.println("5) delete by Id");
        //personClient.deleteById(0);
        //System.out.println("----------------");

        System.out.println("6) delete all");
        personClient.deleteAll();






        System.exit(0);
    }
}

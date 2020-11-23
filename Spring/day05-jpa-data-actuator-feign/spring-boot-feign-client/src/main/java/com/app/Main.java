package com.app;

import com.app.client.PersonRestClient;
import com.app.model.PersonDto;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private PersonRestClient personRestClient;

    @Override
    public void run(String... args) throws Exception {
        PersonDto personDto = new PersonDto("NameWWWWW", 22);

       Response response =  personRestClient.create(personDto);
        System.out.println(response.status());


        List<PersonDto> list =  personRestClient.findAll();
        for(PersonDto dto: list){
            System.out.println(dto);
        }
    }
}

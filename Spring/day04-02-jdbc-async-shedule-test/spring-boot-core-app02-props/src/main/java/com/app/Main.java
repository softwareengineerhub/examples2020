package com.app;

import com.app.model.MyModel;
import com.app.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;

@SpringBootApplication
@PropertySource("data.properties")
public class Main implements CommandLineRunner {

    @Inject
    private SimpleService simpleService;
    @Autowired
    private MyModel myModel;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        simpleService.doAction();
        System.out.println(myModel);
    }
}

package com.app;

import com.app.model.MyModel;
import com.app.repo.MyRepo;
import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private MyModel myModel;
    @Autowired
    private MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myService.doAction(myModel);
        System.out.println(myService.getSize());
    }

    @Bean
    public MyService myService(){
        return new MyService(myRepo());
    }

    @Bean
    public MyRepo myRepo(){
        return new MyRepo();
    }

    @Bean
    public MyModel myModel(){
        MyModel myModel = new MyModel();
        myModel.setName("A");
        return myModel;
    }



}

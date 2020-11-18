package com.app;

import com.app.model.MyModel;
import com.app.repo.MyRepo;
import com.app.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
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


    @Bean
    public MyModel myModel2(){
        MyModel myModel = new MyModel();
        myModel.setName("b");
        return myModel;
    }



}

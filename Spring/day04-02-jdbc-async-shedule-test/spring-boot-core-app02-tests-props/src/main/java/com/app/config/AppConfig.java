package com.app.config;

import com.app.model.MyModel;
import com.app.repo.MyRepo;
import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService(){
        return new MyService(myRepo());
    }

    @Bean
    public MyRepo myRepo(){
        return new MyRepo();
    }

}

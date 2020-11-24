package com.app.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Sample {
//SPRING_DATASOURCE_URL
    @Value("${spring.datasource.url}")
    private String url;
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init(){
        System.out.println("######the-url="+url);
        System.out.println("env!!!!!!the-url="+environment.getProperty("spring.datasource.url"));
    }

}

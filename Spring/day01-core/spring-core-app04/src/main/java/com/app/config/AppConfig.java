package com.app.config;

import com.app.dao.Dao;
import com.app.dao.DaoImpl;
import com.app.processor.DataProcessor;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.app"})
public class AppConfig {
    @Autowired
    private Dao dao;

    /*@Bean
    public Dao daoImpl(){
        return new DaoImpl();
    }*/

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("singleton")
    @Lazy(value = false)
    public PersonService personService(){
        PersonService personService = new PersonService();
        personService.setDao(dao);
        return personService;
    }

    @Bean
    public DataProcessor dataProcessor(){
        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.setPersonService(personService());
        return dataProcessor;
    }
}

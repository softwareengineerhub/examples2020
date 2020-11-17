package com.app.main;

import com.app.dao.Dao;
import com.app.dao.DaoImpl;
import com.app.model.Person;
import com.app.processor.DataProcessor;
import com.app.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*Dao dao = new DaoImpl();

        PersonService personService = new PersonService();
        personService.setDao(dao);

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.setPersonService(personService);*/

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");


        DataProcessor dataProcessor = ctx.getBean("dataProcessor", DataProcessor.class);
        DataProcessor dataProcessor1 = ctx.getBean("dataProcessor", DataProcessor.class);
        //DataProcessor dataProcessor2 = new DataProcessor();
        System.out.println("dp.hash="+dataProcessor.hashCode());
        System.out.println("dp1.hash="+dataProcessor1.hashCode());
       // System.out.println("dp2.hash="+dataProcessor2.hashCode());




        dataProcessor.doAction(1, "Name1");
        List<Person> persons = dataProcessor.doAction(2, "Name2");
        for(Person p: persons){
            System.out.println(p);
        }

        ctx.close();


    }

}

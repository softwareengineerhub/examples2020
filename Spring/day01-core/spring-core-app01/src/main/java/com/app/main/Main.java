package com.app.main;

import com.app.dao.Dao;
import com.app.dao.DaoImpl;
import com.app.model.Person;
import com.app.processor.DataProcessor;
import com.app.service.PersonService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dao dao = new DaoImpl();

        PersonService personService = new PersonService();
        personService.setDao(dao);

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.setPersonService(personService);

        dataProcessor.doAction(1, "Name1");
        List<Person> persons = dataProcessor.doAction(2, "Name2");
        for(Person p: persons){
            System.out.println(p);
        }

    }

}

package com.app.service;

import com.app.dao.Dao;
import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
    /*@Autowired
    //@Qualifier("xmlDao")
    @Qualifier("daoImpl")
    private Dao dao;*/

    @Resource
    private Dao xmlDao;

    public void createPerson(Person person){
        xmlDao.save(person);
    }

    public List<Person> readAll(){
        return xmlDao.readAll();
    }

    public void setDao(Dao dao) {
        this.xmlDao = dao;
    }
}

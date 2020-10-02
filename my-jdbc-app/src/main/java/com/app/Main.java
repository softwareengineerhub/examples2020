package com.app;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person("Name3", 3);
        //personDao.create(person);
        personDao.create2(person);

        List<Person> persons = personDao.readAll();
        for(Person p: persons){
            System.out.println(p);
        }

        System.out.println("------count----");
        System.out.println(personDao.count());

        System.out.println("------read by id =1----");
        System.out.println(personDao.readById(1));

        System.out.println("------update by id =1----");
        Person person1 = new Person("Name1-Update", 11);
        personDao.update(1, person1);
        System.out.println(personDao.readById(1));

        personDao.deleteById(2);


    }

}

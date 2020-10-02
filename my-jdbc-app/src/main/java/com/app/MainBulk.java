package com.app;

import java.util.ArrayList;
import java.util.List;

public class MainBulk {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("testA", 10));
        persons.add(new Person("testB", 11));
        persons.add(new Person("testC", 12));
       // personDao.createBulk(persons);

        personDao.createBulk2(new Person("Q", 1), new Person("W", 2));
    }

}

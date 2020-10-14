package com.app.main;

import com.app.dao.PersonDao;
import com.app.entity.Person;
import com.app.model.Cap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        Person p = new Person();
        p.setName("Name2");
        p.setAge(2);

        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        p.setList(list);

        Cap cap = new Cap();
        cap.setTitle("t1");
        p.setCap(cap);

        Cap cap2 = new Cap();
        cap2.setTitle("t2");
        List<Cap> capList = new ArrayList<>();
        capList.add(cap2);
        p.setListCap(capList);

        personDao.create(p);

        Person p1 = personDao.read(1);
        System.out.println(p1);

        personDao.delete(2);

        Person person = new Person();
        person.setAge(66);
        person.setName("update66");
        personDao.update(person, 1);
    }

}

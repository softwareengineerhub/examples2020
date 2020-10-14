package com.app.dao;

import com.app.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDao {
    private EntityManager em;

    public PersonDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
        em = factory.createEntityManager();
    }

    public void create(Person person){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
    }

    public Person read(int id){
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        em.getTransaction().commit();
        return p;
    }

    public void update(Person candidate, int id){
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        if(p!=null) {
            p.setName(candidate.getName());
            p.setAge(candidate.getAge());
        }
        em.persist(candidate);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        if(p!=null) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }
}

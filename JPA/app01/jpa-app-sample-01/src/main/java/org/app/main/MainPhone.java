package org.app.main;

import org.app.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainPhone {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit02");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Phone phone = new Phone();
        phone.setTitle("Phone1");
        phone.setPrice(1);
        phone.setYear(3);

       // em.persist(phone);

        Phone phone2 = new Phone();
        phone2.setTitle("Phone2");
        phone2.setPrice(1);
        phone2.setYear(2);
        //em.persist(phone2);

        PhonePk phonePk = new PhonePk(1,1);
        Phone res = em.find(Phone.class, phonePk);
        System.out.println(res);

        em.getTransaction().commit();
    }
}

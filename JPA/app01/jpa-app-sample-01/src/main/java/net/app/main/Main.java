package net.app.main;

import net.app.entity.ChildA;
import net.app.entity.ChildB;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit03").createEntityManager();

        em.getTransaction().begin();

        ChildA childA = new ChildA();
        childA.setTitleA("A");
        childA.setName("nameA");
        em.persist(childA);

        ChildB childB = new ChildB();
        childB.setTitleB("B");
        childB.setName("B");
        em.persist(childB);



        em.getTransaction().commit();
    }
}

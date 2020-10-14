package net.app.main;

import net.app.entity.ChildA;
import net.app.entity.ChildB;
import net.app.entity.RootChild;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainRoot {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit03").createEntityManager();

        em.getTransaction().begin();

        RootChild rootChild = new RootChild();
        rootChild.setValue(1);
        rootChild.setName("NameA");
        rootChild.setTitle("titileA");
        em.persist(rootChild);


        em.getTransaction().commit();
    }
}

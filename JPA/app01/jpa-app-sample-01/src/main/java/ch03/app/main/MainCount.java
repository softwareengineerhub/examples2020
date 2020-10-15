package ch03.app.main;

import ch03.app.entity.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainCount {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit06").createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Long> query = em.createNamedQuery("mouse.count", Long.class);
        long count = query.getSingleResult();


        System.out.println(count);


        em.getTransaction().commit();
    }
}

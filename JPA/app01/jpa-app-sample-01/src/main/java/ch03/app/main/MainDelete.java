package ch03.app.main;

import ch03.app.entity.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MainDelete {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit06").createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Mouse> query = em.createNamedQuery("mouse.deleteByTitle", Mouse.class);
        query.setParameter("title", "Update");
        query.executeUpdate();
        

        em.getTransaction().commit();
    }
}

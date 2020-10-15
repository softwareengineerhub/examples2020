package ch03.app.main;

import ch03.app.entity.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit06").createEntityManager();
        em.getTransaction().begin();

        for(int i=0;i<10;i++) {
            Mouse mouse = new Mouse();
            mouse.setPrice(i);
            mouse.setTitle("Title"+i);
            em.persist(mouse);
        }

        em.getTransaction().commit();
    }
}

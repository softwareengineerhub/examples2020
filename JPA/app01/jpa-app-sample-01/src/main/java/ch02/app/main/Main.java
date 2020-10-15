package ch02.app.main;

import ch02.app.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit05").createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setName("Name1");
        user.setAge(1);
        em.persist(user);
        System.out.println("Main.em.persist");
        em.getTransaction().commit();
        System.out.println("Main.em.commit");
    }
}

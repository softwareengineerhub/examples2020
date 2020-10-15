package ch02.app.main;

import ch02.app.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainLoad {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit05").createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, 2);
        //em.remove(user);
        System.out.println(user);

        em.getTransaction().commit();

    }
}

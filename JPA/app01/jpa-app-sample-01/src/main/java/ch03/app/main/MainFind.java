package ch03.app.main;

import ch03.app.entity.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainFind {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit06").createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Mouse> query = em.createQuery("SELECT m FROM Mouse m", Mouse.class);
        List<Mouse> list =  query.getResultList();

        for(Mouse m: list){
            System.out.println(m);
        }

        em.getTransaction().commit();
    }
}

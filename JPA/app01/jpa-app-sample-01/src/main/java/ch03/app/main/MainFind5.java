package ch03.app.main;

import ch03.app.entity.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainFind5 {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit06").createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Mouse> query = em.createNamedQuery("mouse.findAll", Mouse.class);
        List<Mouse> list =  query.getResultList();


        for(Mouse m: list){
            System.out.println(m);
        }

        em.getTransaction().commit();
    }
}

package ch06.app.main;

import ch05.app.entity.Goods;
import ch05.app.entity.Shop;
import ch06.app.entity.A;
import ch06.app.entity.B;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit09").createEntityManager();
        em.getTransaction().begin();

        A a = new A();
        a.setTitle("a1");
        A a2 = new A();
        a2.setTitle("a2");
        A a3 = new A();
        a3.setTitle("a3");

        em.persist(a);
        em.persist(a2);
        em.persist(a3);

        List<A> listA = new ArrayList<>();
        listA.add(a);
        listA.add(a2);
        listA.add(a3);

        B b  = new B();
        b.setTitle("b1");
        b.setListA(listA);

        B b2  = new B();
        b2.setTitle("b2");
        b2.setListA(listA);

        em.persist(b);
        em.persist(b2);





        em.getTransaction().commit();
    }
}

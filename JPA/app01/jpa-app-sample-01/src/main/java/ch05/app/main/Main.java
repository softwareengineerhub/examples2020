package ch05.app.main;

import ch04.app.entity.Author;
import ch04.app.entity.Book;
import ch05.app.entity.Goods;
import ch05.app.entity.Shop;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit08").createEntityManager();
        em.getTransaction().begin();

        Goods g1 = new Goods();
        g1.setPrice(1);
        g1.setTitle("G1");
        em.persist(g1);

        Goods g2 = new Goods();
        g2.setPrice(2);
        g2.setTitle("G2");
        em.persist(g2);

        Goods g3 = new Goods();
        g3.setPrice(3);
        g3.setTitle("G3");
        em.persist(g3);

        List<Goods> goodsList = new ArrayList();
        goodsList.add(g1);
        goodsList.add(g2);
        goodsList.add(g3);

        Shop shop = new Shop();
        shop.setName("Shop1");
        shop.setGoodsList(goodsList);

        g1.setShop(shop);
        g2.setShop(shop);
        g3.setShop(shop);
      /*  em.persist(g1);
        em.persist(g2);
        em.persist(g3);*/

        em.persist(shop);




        em.getTransaction().commit();
    }
}

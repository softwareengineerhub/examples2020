package ch01.app.main;

import ch01.app.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        EntityManager em = Persistence.createEntityManagerFactory("unit04").createEntityManager();
        em.getTransaction().begin();
        Thread.sleep(5000);

        /*Company company = new Company();
        company.setName("Company1");
        em.persist(company);*/


        Company company = em.find(Company.class, 1);
        company.setName("Main2");
        Thread.sleep(10000);
        em.persist(company);


        em.getTransaction().commit();
    }

}

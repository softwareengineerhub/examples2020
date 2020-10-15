package ch01.app.main;

import ch01.app.entity.Company;
import com.app.entity.Person;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        EntityManager em = Persistence.createEntityManagerFactory("unit04").createEntityManager();
        em.getTransaction().begin();
        Thread.sleep(5000);

        /*Company company = new Company();
        company.setName("Company1");
        em.persist(company);*/


        Company company = em.find(Company.class, 1);
        Thread.sleep(1000);
        company.setName("Main1");
        em.persist(company);


        em.getTransaction().commit();
    }

}

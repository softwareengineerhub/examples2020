package org.app.main;

import org.app.entity.Computer;
import org.app.entity.ComputerId;
import org.app.entity.Phone;
import org.app.entity.PhonePk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainComputer {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit02");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        ComputerId computerId = new ComputerId();
        computerId.setPrice(1);
        computerId.setYear(1);
        Computer computer = new Computer();
        computer.setComputerId(computerId);
        computer.setName("C1");

        em.persist(computer);



        Computer res = em.find(Computer.class, computerId);
        System.out.println(res);

        em.getTransaction().commit();
    }
}

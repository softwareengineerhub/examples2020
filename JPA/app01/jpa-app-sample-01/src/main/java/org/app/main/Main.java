package org.app.main;

import org.app.entity.Car;
import org.app.entity.CarDescription;
import org.app.entity.ColorData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit02");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        CarDescription carDescription = new CarDescription();
        carDescription.setHeight(1);
        carDescription.setWidth(2);

        Car car = new Car();
        car.setName("carA");
        car.setCarDescription(carDescription);

        car.setColorData(ColorData.A);

        em.persist(car);


        em.getTransaction().commit();
    }
}

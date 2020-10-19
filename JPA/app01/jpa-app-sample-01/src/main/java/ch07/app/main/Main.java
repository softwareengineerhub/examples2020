package ch07.app.main;

import ch07.app.entity.MyCompany;
import ch07.app.entity.MyEmployee;
import ch07.app.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();
        List<MyEmployee> employeeList = new ArrayList();

        MyEmployee myEmployeeA1 = new MyEmployee();
        myEmployeeA1.setName("A1");
        employeeList.add(myEmployeeA1);

        MyEmployee myEmployeeA2 = new MyEmployee();
        myEmployeeA2.setName("A2");
        employeeList.add(myEmployeeA2);

        MyCompany myCompany  = new MyCompany();
        myCompany.setTitle("Company-A");
        myCompany.setEmployeeList(employeeList);
        em.persist(myCompany);

        employeeList = new ArrayList();
        MyEmployee myEmployeeB1 = new MyEmployee();
        myEmployeeB1.setName("B1");
        employeeList.add(myEmployeeB1);

        MyEmployee myEmployeeB2 = new MyEmployee();
        myEmployeeB2.setName("B2");
        employeeList.add(myEmployeeB2);

        myCompany  = new MyCompany();
        myCompany.setTitle("Company-B");
        myCompany.setEmployeeList(employeeList);
        em.persist(myCompany);


        Task task = new Task();
        task.setDescription("task1");
        task.setMyEmployee(myEmployeeA1);

        Task task2 = new Task();
        task2.setDescription("task2");
        task2.setMyEmployee(myEmployeeA1);


        Task task3 = new Task();
        task3.setDescription("task3");
        task3.setMyEmployee(myEmployeeA2);

        Task task4 = new Task();
        task4.setDescription("task4");
        task4.setMyEmployee(myEmployeeA2);


        Task task5 = new Task();
        task5.setDescription("task5");
        task5.setMyEmployee(myEmployeeB1);

        Task task6 = new Task();
        task6.setDescription("task6");
        task6.setMyEmployee(myEmployeeB2);


        em.persist(task);
        em.persist(task2);
        em.persist(task3);
        em.persist(task4);
        em.persist(task5);
        em.persist(task6);





        em.getTransaction().commit();
    }
}

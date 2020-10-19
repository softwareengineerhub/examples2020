package ch07.app.main;

import ch07.app.entity.MyCompany;
import ch07.app.entity.MyEmployee;
import ch07.app.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        Main2 app = new Main2();
        //app.findAllEmployeeByCompanyName();
        //app.findAllTasksByEmployeeName();
        //app.findAllTasksByEmployeeName2();
        app.findAllTasksByCompanyName();
    }

    private void findAllTasksByCompanyName(){
        String companyName = "Company-B";
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();
        //SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.id in (SELECT d.id FROM Device d JOIN d.site s WHERE s.nameOfSite='site2')
        String jpql = "SELECT t FROM Task t JOIN t.myEmployee e WHERE e member of (SELECT c.employeeList FROM MyCompany c WHERE c.title=:title)";
        TypedQuery<Task> typedQuery = em.createQuery(jpql, Task.class);
        typedQuery.setParameter("title", companyName);
        List<Task> res =  typedQuery.getResultList();
        for(Task t: res){
            System.out.println(t.getId()+"; "+t.getDescription());
        }
        em.getTransaction().commit();
    }

    private void findAllTasksByEmployeeName2(){
        String employeeName = "A1";
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT t FROM Task t JOIN t.myEmployee e WHERE e.name=:name";
        TypedQuery<Task> typedQuery = em.createQuery(jpql, Task.class);
        typedQuery.setParameter("name", employeeName);
        List<Task> res =  typedQuery.getResultList();
        for(Task t: res){
            System.out.println(t.getId()+"; "+t.getDescription());
        }
        em.getTransaction().commit();
    }

    private void findAllTasksByEmployeeName(){
        String employeeName = "B1";
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT t FROM Task t WHERE t.myEmployee.id in  " +
                " (SELECT e.id FROM MyEmployee e WHERE e.name=:name)";
        TypedQuery<Task> typedQuery = em.createQuery(jpql, Task.class);
        typedQuery.setParameter("name", employeeName);
        List<Task> res =  typedQuery.getResultList();
        for(Task t: res){
            System.out.println(t.getId()+"; "+t.getDescription());
        }
        em.getTransaction().commit();
    }

    private void findAllEmployeeByCompanyName(){
        String companyName = "Company-B";
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT c.employeeList FROM MyCompany c WHERE c.title=:title";
        TypedQuery<MyEmployee> typedQuery = em.createQuery(jpql, MyEmployee.class);
        typedQuery.setParameter("title", companyName);
        List<MyEmployee> res =  typedQuery.getResultList();
        for(MyEmployee emp: res){
            System.out.println(emp.getId()+"; "+emp.getName());
        }
        em.getTransaction().commit();
    }







    private void m(){
        EntityManager em = Persistence.createEntityManagerFactory("unit10").createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
    }
}

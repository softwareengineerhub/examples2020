package com.app.repository;

import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {


    public List<Person> findAllByName(String name);

    public List<Person> findAllByNameAndAge(String name, int age);

    @Query(value = "SELECT count(*) from person where name=:name and age=:age", nativeQuery = true)
    public long nativeCount(String name, int age);

    @Query(value = "SELECT count(p) From Person p where p.name=:name and p.age=:age")
    public long jpaCount(String name, int age);

    @Query(value = "DELETE from  Person WHERE age=:age and name=:name", nativeQuery = true)
    @Modifying
    public void nativeRemoveByNameAndAge(String name, int age);

    @Query(value = "DELETE from  Person p WHERE p.age=:age and p.name=:name")
    @Modifying
    public void jpaRemoveByNameAndAge(String name, int age);






}

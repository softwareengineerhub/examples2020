package com.app.bean;

import com.app.domen.Person;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonDaoImpl implements PersonDao {
    @Resource(name = "myDs")
    private DataSource ds;

    @Override
    public void create(Person person) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT into person(name, age) VALUES(?,?)");
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Person findById(int id) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * from person where id=?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            Person p = null;
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                p = new Person(name, age);
            }
            return p;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Person> findAll() {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * from person");
            ResultSet rs = ps.executeQuery();
            List<Person> persons = new ArrayList();
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                persons.add(new Person(name, age));
            }
            return persons;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(int id, Person person) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE person SET name=?, age=? WHERE id=?");
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.setObject(3, id);
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM person WHERE id=?");
            ps.setObject(1, id);
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection c = ds.getConnection()) {
            c.prepareStatement("DELETE from person").execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

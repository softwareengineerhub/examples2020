package com.app.rest.api;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private DataSource ds;

    public PersonDao(DataSource ds) {
        this.ds = ds;
    }


    public void create(Person p){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO person(name, age, description)  VALUES(?,?,?)");
            ps.setObject(1, p.getName());
            ps.setObject(2, p.getAge());
            ps.setObject(3, p.getDescription());
            ps.execute();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Person read(int id){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * from person where id=?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            Person p = null;
            while(rs.next()){
                p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
            }
            return p;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<Person> readAll(){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * from person");
            List<Person> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            Person p = null;
            while(rs.next()){
                p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
            return list;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void update(Person candidate, int id){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("UPDATE person set name=?,age=?,description=? WHERE id = ?");
            ps.setObject(1, candidate.getName());
            ps.setObject(2, candidate.getAge());
            ps.setObject(3, candidate.getDescription());
            ps.setObject(4, id);
            ps.execute();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void delete(int id){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM person where id=?");
            ps.setObject(1, id);
            ps.execute();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

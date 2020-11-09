package com.app.bean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SampleBean {

    @Resource(name = "myDs3")
    private DataSource ds;

    public void process(){
        m1();
        m2();
    }

    public void m1(){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person(name, age) VALUES(?,?)");
            ps.setObject(1, "m1");
            ps.setObject(2, 100);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void m2(){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person(name, age) VALUES(?,?)");
            ps.setObject(1, "m2");
            ps.setObject(2, 200);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

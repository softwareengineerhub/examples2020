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
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class MyBean2 {

    @Resource(name = "myDs3")
    private DataSource ds;

    public void doOperation2(){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person(name, age) VALUES(?,?)");
            ps.setObject(1, "Name2-operation");
            ps.setObject(2, 200);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

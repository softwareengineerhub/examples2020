package com.app.tr;

import com.app.exception.MySqlException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
public class MyTrBean2 {

    @Resource(name = "myDs")
    private DataSource ds;

    public void doAction() throws MySqlException {
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person-test(name, age) values(?,?)");
            ps.setObject(1, "Name2");
            ps.setObject(2, 2);
            ps.execute();
        }catch (Exception ex){
            throw  new MySqlException(ex);
        }
    }

}

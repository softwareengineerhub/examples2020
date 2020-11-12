package com.app.tr;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Stateless
public class MyTrBean {

    @Resource(name = "myDs")
    private DataSource ds;

    public void doAction(){
        try(Connection c = ds.getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person(name, age) values(?,?)");
            ps.setObject(1, "Name1");
            ps.setObject(2, 1);
            ps.execute();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}

package com.app.tr;

import com.app.exception.MySqlException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyTrBean3 {

    @Resource(name = "myDs")
    private DataSource ds;
    @Resource
    private UserTransaction userTransaction;

    public void doAction() throws MySqlException {

        try(Connection c = ds.getConnection()){
            userTransaction.begin();
            PreparedStatement ps = c.prepareStatement("insert into person(name, age) values(?,?)");
            ps.setObject(1, "Name3");
            ps.setObject(2, 3);
            ps.execute();
            userTransaction.commit();
        }catch (Exception ex){
            try {
                userTransaction.rollback();
            } catch (SystemException e) {
                e.printStackTrace();
            }
            throw  new MySqlException(ex);
        }


    }

}

package com.app.tr;

import com.app.exception.MySqlException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;

@Stateless
public class MyDataProcessor {
    @EJB
    private MyTrBean myTrBean;
    @EJB
    private MyTrBean2 myTrBean2;

    public void doOperation() throws MySqlException {
        myTrBean.doAction();
        myTrBean2.doAction();
    }
}

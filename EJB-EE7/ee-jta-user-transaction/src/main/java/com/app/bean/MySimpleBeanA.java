package com.app.bean;

import com.app.exception.MyException;

import javax.ejb.Stateless;
import java.sql.SQLException;

@Stateless
public class MySimpleBeanA {


    public void doAction1(int a){
        System.out.println("a="+a+"; hash="+hashCode());
        if(a<0){
            throw new RuntimeException("Incorrect value");
        }
    }


    public void doAction2(int a2) throws SQLException {
        System.out.println("a2="+a2+"; hash="+hashCode());
        if(a2<0){
            throw new SQLException("Incorrect value");
        }
    }

    public void doAction3(int a3){
        System.out.println("a3="+a3+"; hash="+hashCode());
        if(a3<0){
            throw new MyException("Incorrect value");
        }
    }




}

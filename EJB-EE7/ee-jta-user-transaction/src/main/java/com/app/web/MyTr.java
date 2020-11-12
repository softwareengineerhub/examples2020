package com.app.web;

import com.app.bean.MySimpleBeanA;
import com.app.tr.MyDataProcessor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "myTr", urlPatterns = {"/myTr"})
public class MyTr extends HttpServlet {
    @EJB
    private MyDataProcessor myDataProcessor;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            myDataProcessor.doOperation();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

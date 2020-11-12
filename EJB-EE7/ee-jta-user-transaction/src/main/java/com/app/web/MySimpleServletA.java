package com.app.web;

import com.app.bean.MySimpleBeanA;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mySimpleServletA", urlPatterns = {"/mySimpleServletA"})
public class MySimpleServletA extends HttpServlet {
    @EJB
    private MySimpleBeanA mySimpleBeanA;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int a = Integer.parseInt(req.getParameter("a"));
            mySimpleBeanA.doAction3(a);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

package com.app.web;

import com.app.bean.BusinessProcessor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletA", urlPatterns = {"/myServletA"})
public class MyServletA extends HttpServlet {
    @EJB
    private BusinessProcessor businessProcessor;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        businessProcessor.doAction();
    }
}

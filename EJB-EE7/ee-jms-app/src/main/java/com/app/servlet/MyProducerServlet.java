package com.app.servlet;

import com.app.jms.MyProducer;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myProducerServlet", urlPatterns = {"/myProducerServlet"})
public class MyProducerServlet extends HttpServlet {
    @EJB
    private MyProducer myProducer;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("a");
        myProducer.send(value);
    }
}

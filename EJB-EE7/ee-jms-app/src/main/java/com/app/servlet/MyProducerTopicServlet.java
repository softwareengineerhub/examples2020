package com.app.servlet;

import com.app.jms.MyProducer;
import com.app.jms.MyProducerTopic;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myProducerTopicServlet", urlPatterns = {"/myProducerTopicServlet"})
public class MyProducerTopicServlet extends HttpServlet {

    @EJB
    private MyProducerTopic myProducerTopic;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("a");
        myProducerTopic.send(value);
    }
}

package com.app.web;

import com.app.bean.BusinessProcessor;
import com.app.bean.SampleBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletB", urlPatterns = {"/myServletB"})
public class MyServletB extends HttpServlet {
    @EJB
    private SampleBean sampleBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sampleBean.process();
    }
}

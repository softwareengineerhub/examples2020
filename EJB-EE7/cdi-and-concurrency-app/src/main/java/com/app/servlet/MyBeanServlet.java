package com.app.servlet;

import com.app.bean.MyBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myBeanServlet", urlPatterns = {"/myBeanServlet"})
public class MyBeanServlet extends HttpServlet {
    @Inject
    private MyBean myBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int res = myBean.add(1,2);
        System.out.println("res="+res);
    }
}

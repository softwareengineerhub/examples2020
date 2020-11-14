package com.app.servlet;

import com.app.bean.MyBean;
import com.app.bean4.Phone;
import com.app.bean4.Tag;
import com.app.bean4.Tag2;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myBeanServletPhone", urlPatterns = {"/myBeanServletPhone"})
public class MyBeanServletPhone extends HttpServlet {
    @Inject
    @Tag2
    private Phone phone;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phone.call();
    }
}

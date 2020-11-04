package com.app.web.servlet;

import com.app.bean.singleton.MySimpleBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mySimpleBeanServlet", urlPatterns = {"/mySimpleBeanServlet"})
public class MySimpleBeanServlet extends HttpServlet {

    @Inject
    private MySimpleBean mySimpleBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mySimpleBean.doAction();
    }
}

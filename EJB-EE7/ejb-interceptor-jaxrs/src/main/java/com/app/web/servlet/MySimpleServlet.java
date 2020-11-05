package com.app.web.servlet;

import com.app.beans.MySimpleBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mySimpleServlet", urlPatterns = {"/mySimpleServlet"})
public class MySimpleServlet extends HttpServlet {
    @Inject
    private MySimpleBean mySimpleBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int res = mySimpleBean.doAction3(-1, 2);
        System.out.println("res=" + res);
    }
}

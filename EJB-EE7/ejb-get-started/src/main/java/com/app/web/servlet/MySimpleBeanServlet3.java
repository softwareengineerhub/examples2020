package com.app.web.servlet;

import com.app.bean.singleton.MySimpleBean2;
import com.app.bean.singleton.MySimpleBean3;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Future;

@WebServlet(name = "mySimpleBeanServlet3", urlPatterns = {"/mySimpleBeanServlet3"})
public class MySimpleBeanServlet3 extends HttpServlet {

    @Inject
    private MySimpleBean3 mySimpleBean3;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mySimpleBean3.doAction3();
    }
}

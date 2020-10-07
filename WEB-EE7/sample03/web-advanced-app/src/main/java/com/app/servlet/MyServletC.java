package com.app.servlet;

import com.app.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletC", urlPatterns = {"/myServletC"})
public class MyServletC extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUtils myUtils = (MyUtils) req.getServletContext().getAttribute("myUtils");
        myUtils.doAction();
    }
}

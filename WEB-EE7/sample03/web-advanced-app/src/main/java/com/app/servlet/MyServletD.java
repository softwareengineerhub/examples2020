package com.app.servlet;

import com.app.utils.MyUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletD", urlPatterns = {"/myServletD"})
public class MyServletD extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("a", "A");
        servletContext.setAttribute("a", "A1");
        servletContext.setAttribute("a", null);
        servletContext.removeAttribute("a");


    }
}

package com.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletA", urlPatterns = {"/myServletA"})
public class MyServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServletA.service(). @START");
        super.service(req, resp);
        System.out.println("myServletA.service(). @FINISH");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServletA.doGet()");
        String name = req.getParameter("name");
        String ageValue = req.getParameter("age");
        int age = Integer.parseInt(ageValue);
        System.out.println("name=" + name);
        System.out.println("age=" + age);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServletA.doPost()");
        String name = req.getParameter("name");
        String ageValue = req.getParameter("age");
        int age = Integer.parseInt(ageValue);
        System.out.println("name=" + name);
        System.out.println("age=" + age);
    }


}

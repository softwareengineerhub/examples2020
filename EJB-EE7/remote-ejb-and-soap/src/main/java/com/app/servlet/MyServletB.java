package com.app.servlet;

import com.app.bean.Summator;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServletB", urlPatterns = {"/myServletB"})
public class MyServletB extends HttpServlet {
    @EJB(lookup = "summatorB#com/app/bean/Summator")
    private Summator summator;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int res = summator.add(10, 2);
        System.out.println(res);

    }
}

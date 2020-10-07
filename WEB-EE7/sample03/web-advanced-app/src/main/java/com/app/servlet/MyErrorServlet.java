package com.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myErrorServlet", urlPatterns = {"/myErrorServlet"})
public class MyErrorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{'status':'error'}";
        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
}

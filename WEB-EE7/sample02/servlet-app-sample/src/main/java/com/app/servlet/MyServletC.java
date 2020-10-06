package com.app.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServletC", urlPatterns = {"/myServletC"})
public class MyServletC extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServletC.service(). @START");
        PrintWriter pw = response.getWriter();
        pw.append("MyServletC.service(). @START;   ");
        response.setHeader("MyServletCBegin", "START");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myServletD");
        requestDispatcher.forward(request, response);

        response.setHeader("MyServletCBeginEnd", "FINISH");
        pw.append("MyServletC.service(). @FINISH;   ");
        System.out.println("MyServletC.service(). @FINISH");

    }


}

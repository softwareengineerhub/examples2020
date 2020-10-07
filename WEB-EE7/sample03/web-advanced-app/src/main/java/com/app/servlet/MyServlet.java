package com.app.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "MyServlet", urlPatterns = {"/myServlet"})
public class MyServlet extends HttpServlet {

    //Map<String, Object>
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet.doPost()");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myServletB");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet.doGet()");

        request.setAttribute("mykey", "myvalue");
        Enumeration<String> names =  request.getAttributeNames();
        while(names.hasMoreElements()){
            String key = names.nextElement();
            System.out.println(key);
        }
        //request.removeAttribute("mykey");
        //request.setAttribute("mykey", null);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myServletB");
        requestDispatcher.forward(request, response);
    }
}

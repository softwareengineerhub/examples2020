package com.app.theweb.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class HelloServlet extends HttpServlet {

    static {
        System.out.println("static{}");
    }

    {
        System.out.println("\t{}");
    }


    public HelloServlet() {
        System.out.println("\t\tConstructor");
    }

    public void init(){
        System.out.println("\t\t\tinit()");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet. service(); hashCode="+hashCode());
    }


    public void destroy(){
        System.out.println("destroy()");
    }
}

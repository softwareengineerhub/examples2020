package com.app.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myPersonalPageServlet", urlPatterns = {"/myPersonalPageServlet"})
public class MyPersonalPageServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("application/html");
        HttpSession session = req.getSession(false);
        String name = session.getAttribute("name")+"";
        PrintWriter pw = resp.getWriter();
        pw.println("<body>");
        pw.println("THIS is your page, "+name);
        String contextPath = req.getContextPath();
        System.out.println("contextPath="+contextPath);
        pw.println("<a href='"+contextPath+"/logout'>logout</>");
        pw.println("</body>");

    }
}

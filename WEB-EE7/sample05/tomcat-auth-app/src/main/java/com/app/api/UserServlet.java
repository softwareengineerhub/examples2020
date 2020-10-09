package com.app.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getRemoteUser();
        String login2 = request.getUserPrincipal().getName();

        PrintWriter pw = response.getWriter();
        pw.println("<body>");
        pw.println("USER PAGE");
        pw.println("<br>");
        pw.println("login="+login);
        pw.println("<br>");
        pw.println("login2="+login2);
        pw.println("</body>");
    }
}

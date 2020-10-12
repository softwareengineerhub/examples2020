package com.app.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuccessServlet", urlPatterns = {"/successServlet"})
public class SuccessServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int processedUsers = (int) request.getAttribute("processedUsers");
        PrintWriter pw = response.getWriter();
        pw.println("<body><h3>");
        pw.println("Successfully added users: ");
        pw.println(processedUsers);
        pw.println("<h3>");
        pw.println("</body>");

    }
}

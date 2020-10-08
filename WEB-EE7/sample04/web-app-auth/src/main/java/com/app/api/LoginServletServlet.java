package com.app.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServletServlet", urlPatterns = {"/loginServletServlet"})
public class LoginServletServlet extends HttpServlet {
    private LoginChecker loginChecker;

    public void init(){
        loginChecker = new LoginCheckerDefaultImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean res = loginChecker.isCorrect(name, password);
        System.out.println("res="+res);
        if(res){
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            resp.sendRedirect("index.html");
        } else {
            resp.setStatus(401);
        }
    }
}

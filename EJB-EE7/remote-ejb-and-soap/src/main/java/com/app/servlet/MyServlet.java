package com.app.servlet;

import com.app.bean.Summator;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServlet", urlPatterns = {"/myServlet"})
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext ctx = new InitialContext();
            Summator summator = (Summator) ctx.lookup("summatorA#com/app/bean/Summator");
            int res=summator.add(1,2);
            System.out.println(res);
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }
}

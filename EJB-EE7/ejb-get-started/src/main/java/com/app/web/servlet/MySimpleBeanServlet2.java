package com.app.web.servlet;

import com.app.bean.singleton.MySimpleBean;
import com.app.bean.singleton.MySimpleBean2;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Future;

@WebServlet(name = "mySimpleBeanServlet2", urlPatterns = {"/mySimpleBeanServlet2"})
public class MySimpleBeanServlet2 extends HttpServlet {

    @Inject
    private MySimpleBean2 mySimpleBean2;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("servlet -start");
            //mySimpleBean2.doAction2Asynch();
            Future<String> future = mySimpleBean2.doAction2Asynch(1);
            String res = future.get();
            System.out.println("res="+res);
            System.out.println("servlet -finish");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

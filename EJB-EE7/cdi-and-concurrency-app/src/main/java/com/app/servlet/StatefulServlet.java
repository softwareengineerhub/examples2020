package com.app.servlet;

import com.app.mystatful.MyDataBean;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "statefulServlet", urlPatterns = {"/statefulServlet"})
public class StatefulServlet extends HttpServlet {
    @EJB
    private MyDataBean myDataBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println("isNew="+session.isNew());
        if(session.isNew()){
            session.setAttribute("data", myDataBean);
        }

        String action = req.getParameter("action");
        if("add".equals(action)){
            MyDataBean bean = (MyDataBean) session.getAttribute("data");
            bean.doAction("a"+new Date());
        }else{
            System.out.println("else!!!!");
            MyDataBean bean = (MyDataBean) session.getAttribute("data");
            System.out.println("####list="+bean.getList());
        }
    }
}

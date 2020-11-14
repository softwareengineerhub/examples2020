package com.app.servlet;

import com.app.bean.MyBean;
import com.app.bean2.DataProcessor;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myBeanServletDataProcessor", urlPatterns = {"/myBeanServletDataProcessor"})
public class MyBeanServletDataProcessor extends HttpServlet {
    @Inject
    private DataProcessor dataProcessor;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dataProcessor.doAction();
    }
}

package com.app.servlet;

import com.app.bean.MyBean;
import com.app.bean3.Car;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myBeanServletCar", urlPatterns = {"/myBeanServletCar"})
public class MyBeanServletCar extends HttpServlet {

    @Inject
    @Named("b")
    private Car car;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        car.drive();
    }
}

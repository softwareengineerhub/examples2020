package com.app.servlet;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "eventServlet", urlPatterns = {"/eventServlet"})
public class EventServlet extends HttpServlet {
    @Inject
    private Event<String> event;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SERVLET.START");
        event.fire("Hello");
        System.out.println("SERVLET.FINISH");
    }
}

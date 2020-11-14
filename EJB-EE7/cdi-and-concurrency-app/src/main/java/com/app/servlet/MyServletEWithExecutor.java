package com.app.servlet;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@WebServlet(name = "/myServletEWithExecutor", urlPatterns = {"/myServletEWithExecutor"})
public class MyServletEWithExecutor extends HttpServlet {
    @Resource
    private ManagedExecutorService executorService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Data";
            }
        });
        try {
            String res=future.get();
            System.out.println("res="+res);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

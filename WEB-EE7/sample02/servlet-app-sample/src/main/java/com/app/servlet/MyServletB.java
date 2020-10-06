package com.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "myServletB", urlPatterns = {"/myServletB"})
public class MyServletB extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServletB.service()");
        //response.sendRedirect("/google.com");

        //response.setStatus(404);
        response.setHeader("mydata", "myvalue");
        response.addCookie(new Cookie("mycookie", "mycookie-value"));



        //response.setContentType("application/json");
        //PrintWriter pw = response.getWriter();

        /*String html = readContent("/mytemplate.txt");
        String res = String.format(html, "NameA", 1);
        pw.println(res);*/

        //String json = "{'name':'NameA', 'age':1}";
        //pw.println(json);


        String json = "{'name':'NameA', 'age':1}";
        ServletOutputStream out = response.getOutputStream();
        out.write(json.getBytes());
        response.setContentType("application/json");



    }


    private String readContent(String filePath){
        try {
            URL url = getClass().getResource(filePath);
            Path path = Paths.get(url.toURI());
            byte[] data = Files.readAllBytes(path);
            return new String(data);
        }catch(Exception ex){
            throw  new RuntimeException(ex);
        }
    }


}

package com.app.api;

import com.app.dao.DataProcessor;
import com.app.dao.DataProcessorFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "uploadServlet", urlPatterns = {"/uploadServlet"})
public class UploadServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getParts();
        Part part = req.getPart("data");
        String submittedFileName = part.getSubmittedFileName();
        String contentType = part.getContentType();
        System.out.println("submittedFileName=" + submittedFileName);
        System.out.println("contentType=" + contentType);
        String type = getType(submittedFileName);
        System.out.println("type=" + type);
        DataProcessor dp = DataProcessorFactory.dataProcessor(type);
        int processedUsers = dp.process(part);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/successServlet");
        req.setAttribute("processedUsers", processedUsers);
        requestDispatcher.forward(req, resp);
    }


    private String getType(String submittedFileName) {
        System.out.println("##############################");
        System.out.println("submittedFileName=" + submittedFileName);
        int index = submittedFileName.lastIndexOf(".");
        String type = submittedFileName.substring(index + 1, submittedFileName.length());
        System.out.println("type=" + type);
        return type;
    }

}

package com.app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "myLoggingFilter", urlPatterns = {"/myServletF"})
public class MyLoggingFilter implements Filter {


    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        System.out.println("--------FILTER.doFilter-----@START");

        chain.doFilter(req, resp);

        System.out.println("--------FILTER.doFilter-----@FINISH; time="+(System.currentTimeMillis()-start));
    }


    /*public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("--------FILTER.doFilter-----@START; name="+name);
        if("Denis".equalsIgnoreCase(name)) {
            chain.doFilter(req, resp);
        }
        System.out.println("--------FILTER.doFilter-----@FINISH");
    }*/

    public void destroy() {

    }

}

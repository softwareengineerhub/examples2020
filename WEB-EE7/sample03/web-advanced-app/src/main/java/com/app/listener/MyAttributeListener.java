package com.app.listener;

import com.app.utils.MyUtils;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String key = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();

        System.out.println("attribute was added; key="+key+"; value="+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String key = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();

        System.out.println("attribute was removed; key="+key+"; value="+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String key = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("attribute was replaced; key="+key+"; value="+value);
    }
}

package com.app.web.jaxrs;

import javax.ws.rs.core.Application;
import java.util.Set;

@javax.ws.rs.ApplicationPath("api")
public class MyApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(MySimpleRestApi.class);
        return resources;
    }
}

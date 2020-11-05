package com.app.web.jaxrs;


import com.app.beans.MySimpleBean;
import com.app.beans.MySimpleBean2;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//JAX-RS/ Jersey, RESTeasy

@Path("/simple")
public class MySimpleRestApi {

    @GET
    public String find(){
        System.out.println("find()");
        return "SUCCESS";
    }

    @GET
    @Path("/test")
    public String find1(){
        System.out.println("find1()");
        return "SUCCESS1";
    }

    @GET
    @Path("/test2")
    public String find2(){
        System.out.println("find2()");
        return "SUCCESS2";
    }

    @POST
    public void create(){
        System.out.println("create()");
    }


}

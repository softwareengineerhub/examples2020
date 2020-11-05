package com.app.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInterceptor {

    @AroundInvoke
    public Object proceeed(InvocationContext context){
        try {
            System.out.println("MyInterceptor.@Before method");

            Object target = context.getTarget();
            System.out.println("target="+target);

            Method m = context.getMethod();
            System.out.println("method="+m);

            Object[] params = context.getParameters();
            System.out.println("Params="+ Arrays.toString(params));
            //params[0] = 10;
            //params[1] = 7;
            int a = (int) params[0];
            int b = (int) params[1];

            if(a<0 || b<0){
                return -1;
            }

            Object res = context.proceed();
            System.out.println("MyInterceptor.@After method; res="+res);
            //return ((int)res)+200;
            return res;
            //return res;
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }


    @AroundTimeout
    public Object proceeedTimer(InvocationContext context){
        try {
            System.out.println("Timer. MyInterceptor.@Before timer;");
            Object res = context.proceed();
            System.out.println("Timer. MyInterceptor.@After timer; res="+res);
            return res;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

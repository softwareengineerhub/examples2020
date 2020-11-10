package com.app.main;

import com.app.bean.Summator;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws Exception{
        //environment.put(Context.SECURITY_PRINCIPAL, "weblogic");
        //environment.put(Context.SECURITY_CREDENTIALS, "weblogic1");

        Hashtable configs = new Hashtable();
        configs.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        configs.put(Context.PROVIDER_URL, "t3://localhost:7001/");

        InitialContext initialContext = new InitialContext(configs);
        //Summator summator = (Summator) initialContext.lookup("summatorA#com/app/bean/Summator");
        Summator summator = (Summator) initialContext.lookup("summatorB#com/app/bean/Summator");

        int res = summator.add(11,2);
        System.out.println("res="+res);

    }

}

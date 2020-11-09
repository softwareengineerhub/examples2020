package com.app.bean;

import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BusinessProcessor {
    @EJB
    private MyBean1 myBean1;
    @EJB
    private MyBean2 myBean2;

    public void doAction(){
        myBean1.doOperation1();
        myBean2.doOperation2();
        String s =  null;
        s.toString();

    }
}

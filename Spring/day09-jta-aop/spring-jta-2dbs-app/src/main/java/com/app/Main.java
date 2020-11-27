package com.app;

import com.app.config.AppConfig;
import com.app.service.BusinessProcessorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BusinessProcessorService bps = ctx.getBean(BusinessProcessorService.class);
        bps.doAction();
        System.out.println("!!!Completed!!!");
    }

}

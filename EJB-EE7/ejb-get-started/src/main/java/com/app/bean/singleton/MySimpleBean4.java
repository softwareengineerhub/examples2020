package com.app.bean.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.io.Serializable;
import java.util.Collection;

@Singleton
@Startup
public class MySimpleBean4 {

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void init(){
        ScheduleExpression se = new ScheduleExpression();
        se.second("*/20");
        se.minute("*");
        se.hour("*");
        TimerConfig tc = new TimerConfig();
        tc.setPersistent(false);
        tc.setInfo("Some data");
        timerService.createCalendarTimer(se, tc);

        /*Collection<Timer> collection =  timerService.getTimers();
        for(Timer t: collection){
            if(t.getInfo().equals("action4")){
                t.cancel();
            }
        }*/
    }


    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false, info = "action4")
    public void doAction4(){
        System.out.println("MySimpleBean4.doAction4()");
    }


    @Timeout
    public void doOperation(Timer timer){
        Serializable info = timer.getInfo();
        System.out.println("doOperation.info="+info);
        //timer.cancel();
    }




}

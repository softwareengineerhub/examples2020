package com.app.mystatful;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class MyDataBean {
    private List<String> list;

    @PostConstruct
    public void init(){
        list = new ArrayList<>();
    }

    public void doAction(String s){
        list.add(s);
    }

    public List<String> getList() {
        return list;
    }
}

package ch02.app.entity;

import javax.persistence.PostLoad;
//import javax.persistence.PreLoad;

public class ListenerD {


    @PostLoad
    public void afterFind(Object item){
        System.out.println("ListenerD.@PostLoad: item="+item);
    }




}

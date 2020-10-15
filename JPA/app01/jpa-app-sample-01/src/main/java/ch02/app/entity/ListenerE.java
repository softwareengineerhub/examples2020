package ch02.app.entity;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

public class ListenerE {


    @PreUpdate
    public void beforeUpdate(Object item){
        System.out.println("ListenerC.@PreUpdate: item="+item);
    }


    @PostUpdate
    public void afterUpdate(Object item){
        System.out.println("ListenerC.@PostUpdate: item="+item);
    }



}

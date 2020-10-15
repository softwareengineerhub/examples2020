package ch02.app.entity;

import javax.persistence.PostRemove;
import javax.persistence.PreRemove;

public class ListenerC {


    @PreRemove
    public void beforeDelete(Object item){
        System.out.println("ListenerC.@PreRemove: item="+item);
    }


    @PostRemove
    public void afterDelete(Object item){
        System.out.println("ListenerC.@PostRemove: item="+item);
    }



}

package ch02.app.entity;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class ListenerA {


    @PrePersist
    public void beforeSave(Object item){
        System.out.println("ListenerA.@PrePersist: item="+item);
        User user = (User) item;
        user.setAge(100);
    }


    @PostPersist
    public void afterSave(Object item){
        System.out.println("ListenerA.@PostPersist: item="+item);
    }



}

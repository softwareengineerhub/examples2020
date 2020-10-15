package ch02.app.entity;

import javax.persistence.PrePersist;

public class ListenerB {


    @PrePersist
    public void beforeSave(Object item){
        System.out.println("ListenerB.@PrePersist: item="+item);
        User user = (User) item;
        user.setAge(200);
    }

}

package com.app.repo;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleRepo {

    public void saveData(){
        System.out.println("saveData()");
    }
}

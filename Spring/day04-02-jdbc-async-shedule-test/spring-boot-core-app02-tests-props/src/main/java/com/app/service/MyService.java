package com.app.service;

import com.app.model.MyModel;
import com.app.repo.MyRepo;

public class MyService {
    private MyRepo myRepo;

    public MyService(MyRepo myRepo) {
        this.myRepo = myRepo;
    }

    public void doAction(MyModel myModel){
        if("A".equalsIgnoreCase(myModel.getName())){
            myRepo.save(myModel);
        }
    }

    public int getSize(){
        return myRepo.size();
    }
}

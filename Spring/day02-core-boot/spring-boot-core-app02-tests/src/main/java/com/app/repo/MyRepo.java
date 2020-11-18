package com.app.repo;

import com.app.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class MyRepo {
    private List<MyModel> list = new ArrayList<>();

    public void save(MyModel myModel){
        list.add(myModel);
    }

    public int size(){
        return list.size();
    }

}

package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainMetaData {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        List<Map<String, Object>> result = personDao.metaData();
        for(Map map: result){
            System.out.println(map);
        }
    }

}

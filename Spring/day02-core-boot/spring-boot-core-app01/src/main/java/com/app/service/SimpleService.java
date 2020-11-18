package com.app.service;

import com.app.repo.SimpleRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SimpleService {
    @Inject
    private SimpleRepo simpleRepo;

    public void doAction(){
        simpleRepo.saveData();
    }
}

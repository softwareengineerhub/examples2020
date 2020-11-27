package com.app.service;

import com.app.repository.CompanyRepo;
import com.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {NullPointerException.class})
public class BusinessProcessorService {

    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private EmployeeRepo employeeRepo;


    public void doAction(){
        companyRepo.save("A"+System.currentTimeMillis());
        employeeRepo.save("B"+System.currentTimeMillis(), 1);

        String s = null;
        s.toString();
    }
}

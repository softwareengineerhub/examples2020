package com.app.service;

import com.app.config.AppConfig;
import com.app.model.MyModel;
import com.app.repo.MyRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppWorkflowTest {
    @Autowired
    private MyService myService;
    @Autowired
    private MyModel myModel;

    @Test
    public void test(){
        myService.doAction(myModel);
        System.out.println(myModel);
        int size = myService.getSize();
        assertTrue(1==size);
    }


}

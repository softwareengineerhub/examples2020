package com.app.service;

import com.app.Main;
import com.app.model.MyModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class ApplicationPositiveTest {
    @Autowired
    private MyService myService;
    @Resource
    private MyModel myModel;

    @Test
    public void workflowPositiveTest(){
        myService.doAction(myModel);
        int size = myService.getSize();
        assertTrue(size==1);
    }

}

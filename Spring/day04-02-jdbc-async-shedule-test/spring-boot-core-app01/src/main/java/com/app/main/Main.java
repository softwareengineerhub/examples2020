package com.app.main;

import com.app.service.SimpleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication(scanBasePackages = {"com.app"})
public class Main implements CommandLineRunner {
  //  @Autowired
   // private ApplicationContext applicationContext;

    @Inject
    private SimpleService simpleService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
  //      SimpleService simpleService = applicationContext.getBean(SimpleService.class);
    //    simpleService.doAction();

        simpleService.doAction();
    }
}

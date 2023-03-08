package com.example.demo;

import com.example.demo.test.lookup.GetBeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        GetBeanTest bean = (GetBeanTest)context.getBean("getBeanTest");
        bean.showMe();
    }

}

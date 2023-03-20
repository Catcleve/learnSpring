package com.example.factorybean;

import com.example.factorybean.bean.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FactoryBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FactoryBeanApplication.class, args);
        TestBean bean = (TestBean)run.getBean("fac");
        System.out.println("bean = " + bean);
    }

}

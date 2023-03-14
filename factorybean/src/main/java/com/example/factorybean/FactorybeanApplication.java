package com.example.factorybean;

import com.example.factorybean.bean.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FactorybeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FactorybeanApplication.class, args);
        TestBean bean = (TestBean)run.getBean("testFactoryBean");
        System.out.println("bean = " + bean);
    }

}

package com.example.demo;

import com.example.demo.bean.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author maonengneng
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        TestBean bean = (TestBean)context.getBean("testFactoryBean");
        System.out.println("bean = " + bean);
    }

}

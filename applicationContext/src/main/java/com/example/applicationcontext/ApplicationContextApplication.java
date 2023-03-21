package com.example.applicationcontext;

import com.example.applicationcontext.bean.TestDateValueBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationContextApplication.class, args);
        TestDateValueBean bean = run.getBean(TestDateValueBean.class);
        System.out.println("bean = " + bean);
    }

}

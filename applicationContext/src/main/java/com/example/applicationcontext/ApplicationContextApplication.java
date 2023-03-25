package com.example.applicationcontext;

import com.example.applicationcontext.bean.TestAware;
import com.example.applicationcontext.bean.TestDateValueBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class ApplicationContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationContextApplication.class, args);
        TestDateValueBean bean = run.getBean(TestDateValueBean.class);
        System.out.println("bean = " + bean);
        LocalDateTime dateTime = LocalDateTime.ofInstant(bean.getDate().toInstant(), ZoneId.systemDefault());
        System.out.println("dateTime = " + dateTime);

        TestAware testAware = run.getBean(TestAware.class);
        System.out.println("testAware = " + testAware);

    }

}

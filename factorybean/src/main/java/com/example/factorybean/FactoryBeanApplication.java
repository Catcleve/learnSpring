package com.example.factorybean;

import com.example.factorybean.bean.TestBean;
import com.example.factorybean.bean.TestFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FactoryBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FactoryBeanApplication.class, args);
        //通过工厂获取bean
        TestBean bean = (TestBean)run.getBean("fac");
        System.out.println("bean = " + bean);
        //获取原本的工厂bean
        TestFactoryBean factoryBean = (TestFactoryBean)run.getBean("&fac");
        System.out.println("factoryBean = " + factoryBean);
    }

}

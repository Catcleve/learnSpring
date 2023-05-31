package com.example.demo;

import com.example.demo.test.lookup.GetBeanTest;
import com.example.demo.test.lookup.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试lookup标签
 *
 * xml中的lookup标签或者{@link org.springframework.beans.factory.annotation.Lookup}注解，
 * 可以指定方法的返回值为bean {@link GetBeanTest#getBean()}
 * 不一定是abstract方法
 *
 * @author maonengneng
 * @date 2023/03/07
 */
@SpringBootApplication
public class TestLookup {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestLookup.class);
        User bean = run.getBean(GetBeanTest.class).getBean();
        bean.showMe();
        //ApplicationContext bf = new ClassPathXmlApplicationContext("TestLookup.xml");
        //GetBeanTest getBeanTest = (GetBeanTest)bf.getBean("getBeanTest");
        //getBeanTest.showMe();
    }

}

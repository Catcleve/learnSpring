package com.example.applicationcontext;

import com.example.applicationcontext.aop.service.TestServiceBean;
import com.example.applicationcontext.bean.TestAware;
import com.example.applicationcontext.bean.TestBean;
import com.example.applicationcontext.bean.TestBeanFactoryProcessor;
import com.example.applicationcontext.bean.TestDateValueBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootTest
class ApplicationContextApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {

        TestDateValueBean bean = applicationContext.getBean(TestDateValueBean.class);
        System.out.println("bean = " + bean);
        LocalDateTime dateTime = LocalDateTime.ofInstant(bean.getDate().toInstant(), ZoneId.systemDefault());
        System.out.println("dateTime = " + dateTime);

    }

    @Test
    void TestAware() {
        TestAware testAware = applicationContext.getBean(TestAware.class);
        System.out.println("testAware = " + testAware);

    }

    @Test
    void TestBeanFactoryPostProcessor() {
        TestBeanFactoryProcessor bean = applicationContext.getBean(TestBeanFactoryProcessor.class);
        System.out.println("bean = " + bean);
    }

    @Test
    void TestAop() {
        TestServiceBean bean = (TestServiceBean) applicationContext.getBean("testServiceBean");
        bean.test();
    }

}

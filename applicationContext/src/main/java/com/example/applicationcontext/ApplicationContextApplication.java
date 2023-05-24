package com.example.applicationcontext;

import com.example.applicationcontext.bean.TestBean;
import com.example.applicationcontext.bean.TestConfigurationBean;
import com.example.applicationcontext.bean.TestDateValueBean;
import com.example.applicationcontext.configbean.MyConfig;
import com.example.applicationcontext.event.TestEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = false)
public class ApplicationContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationContextApplication.class, args);
        TestEvent testEvent = new TestEvent(new Object());
        testEvent.setMessage("发布事件");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        testEvent.setTime(LocalDateTime.now().format(formatter));
        run.publishEvent(testEvent);
        TestConfigurationBean bean = (TestConfigurationBean) run.getBean("testConfigurationBean");
        TestConfigurationBean bean1 = (TestConfigurationBean) run.getBean("testConfigurationBean1");
        System.out.println("bean = " + bean);
        System.out.println("bean1 = " + bean1);
        MyConfig bean2 = run.getBean(MyConfig.class);
        TestBean testBean = bean2.testBean();
        System.out.println("testBean = " + testBean);
        System.out.println("bean2 = " + bean2);
    }

}

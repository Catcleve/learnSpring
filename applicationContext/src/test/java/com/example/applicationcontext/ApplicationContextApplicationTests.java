package com.example.applicationcontext;

import com.example.applicationcontext.aop.service.ITestServiceBean;
import com.example.applicationcontext.bean.TestAware;
import com.example.applicationcontext.bean.TestBeanFactoryProcessor;
import com.example.applicationcontext.bean.TestDateValueBean;
import com.example.applicationcontext.configbean.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
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

    /**
     * 测试aop 设置代理方式
     * 经测验 springboot会自动开启aop代理 详见 AOP生效解惑.pdf
     * 在这种情况下 使用EnableAspectJAutoProxy(proxyTargetClass = false)并不能使用jdk动态代理
     * 需要在配置文件中配置
     * spring:
     *   aop:
     *     proxy-target-class: false
     * 才可以在有接口时使用动态代理
，
     * 或者 配置
     * spring:
     *   aop:
     *     auto: false
     * 关掉自动启用代理， 然后使用注解EnableAspectJAutoProxy
     * 默认就是不启用强制使用CGLIB
     *
     * 总结:如果没有在配置中关闭自动开启或者关闭使用CGLIB，那么注解中的指定代理类型不会生效
     */
    @Test
    void TestAop() {
        ITestServiceBean bean = applicationContext.getBean(ITestServiceBean.class);
        bean.test();
        System.out.println(bean.getClass().getSuperclass());
    }

    @Test
    void TestAop1() {
        ITestServiceBean bean = applicationContext.getBean(ITestServiceBean.class);
        bean.test1();
        System.out.println(bean.getClass().getSuperclass());
    }

    /**
     * 测试配置类proxyBeanMethods属性
     * 当proxyBeanMethods为true（默认）时 结果为true 反之为false
     *
     * 原理：为true时会代理 配置类的获取bean的对应方法myBeanPostProcessor()会被spring代理，返回容器中的bean
     */
    @Test
    void testConfiguration() {
        MyConfig bean = applicationContext.getBean(MyConfig.class);
        BeanPostProcessor processor = bean.myBeanPostProcessor();
        BeanPostProcessor processor1 = bean.myBeanPostProcessor();
        System.out.println(processor == processor1);
    }

}

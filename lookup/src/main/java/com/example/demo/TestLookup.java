package com.example.demo;

import com.example.demo.test.lookup.GetBeanTest;
import org.springframework.context.ApplicationContext;
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
public class TestLookup {


    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("TestLookup.xml");
        GetBeanTest getBeanTest = (GetBeanTest)bf.getBean("getBeanTest");
        getBeanTest.showMe();
    }

}

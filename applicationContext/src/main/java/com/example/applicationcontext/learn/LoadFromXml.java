package com.example.applicationcontext.learn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * applicationContext从xml加载bean
 *
 * @author maonengneng
 * @date 2023/03/20
 */
public class LoadFromXml {

    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beanFactoryTest.xml");


    @Test
    public void test1(){

        Object a = ac.getBean("a");
        System.out.println("a = " + a);

        //解析配置文件
        ac.setConfigLocations();
        //具体功能实现，里面按各个方法分好了，一步一步的执行
        ac.refresh();
    }

    @Test
    public void testRefresh(){
        //准备环境变量，系统配置，检测等
        //ac.prepareRefresh();
    }

}

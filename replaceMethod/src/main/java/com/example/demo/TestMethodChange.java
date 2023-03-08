package com.example.demo;

import com.example.demo.test.MethodChange.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMethodChange {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("MethodReplace.xml");
        TestChangeMethod changeMethod = (TestChangeMethod)context.getBean("changeMethod");
        changeMethod.changeMe();
    }

}

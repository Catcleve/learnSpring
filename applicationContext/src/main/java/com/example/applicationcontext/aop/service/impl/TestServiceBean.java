package com.example.applicationcontext.aop.service.impl;

import com.example.applicationcontext.aop.service.ITestServiceBean;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class TestServiceBean implements ITestServiceBean {


    public void test() {
        System.out.println("原方法");
        System.out.println(AopContext.currentProxy().getClass().getSuperclass());
    }


}

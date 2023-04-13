package com.example.applicationcontext.aop.service.impl;

import com.example.applicationcontext.aop.service.ITestServiceBean;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class TestServiceBean implements ITestServiceBean {


    public void test() {
        System.out.println("原方法");
    }

    @Override
    public void test1() {
        //使用这种方法可以调用到增强过的方法 如果直接使用 test()方法则不行
        ITestServiceBean o = (ITestServiceBean) AopContext.currentProxy();
        o.test();
    }


}

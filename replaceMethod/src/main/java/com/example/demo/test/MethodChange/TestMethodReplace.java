package com.example.demo.test.MethodChange;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;


public class TestMethodReplace implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我替换了原有的方法");
        return null;
    }
}

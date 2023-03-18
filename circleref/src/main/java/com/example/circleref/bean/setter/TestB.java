package com.example.circleref.bean.setter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component("sb")
public class TestB {

    @Resource
    private TestC c;

    public TestC getC() {
        return c;
    }
    public void setC(TestC c) {
        this.c = c;
    }
}

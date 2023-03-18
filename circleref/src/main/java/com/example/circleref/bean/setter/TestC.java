package com.example.circleref.bean.setter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component("sc")
public class TestC {



    @Resource
    private TestA a;

    public TestA getA() {
        return a;
    }

    public void setA(TestA a) {
        this.a = a;
    }

}

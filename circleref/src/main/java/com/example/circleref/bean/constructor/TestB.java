package com.example.circleref.bean.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("cb")
public class TestB {

    @Autowired
    public TestB (TestC c) {
        this.c = c;
    }

    private TestC c;

    public TestC getC() {
        return c;
    }
    public void setC(TestC c) {
        this.c = c;
    }
}

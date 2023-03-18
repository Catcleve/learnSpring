package com.example.circleref.bean.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("cc")
public class TestC {

    @Autowired
    public TestC (TestA a) {
        this.a = a;
    }


    private TestA a;

    public TestA getA() {
        return a;
    }

    public void setA(TestA a) {
        this.a = a;
    }

}

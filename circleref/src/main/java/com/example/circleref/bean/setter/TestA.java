package com.example.circleref.bean.setter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component("sa")
public class TestA {

    @Resource
    private TestB b;

    public TestB getB() {
        return b;
    }
    public void setB(TestB b) {
        this.b = b;
    }

}

package com.example.circleref.bean.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("ca")
public class TestA {

    @Autowired
    public TestA (TestB b) {
        this.b = b;
    }

    private TestB b;

    public TestB getB() {
        return b;
    }
    public void setB(TestB b) {
        this.b = b;
    }

}

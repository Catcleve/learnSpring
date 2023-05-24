package com.example.applicationcontext.bean;

import lombok.Data;

@Data
public class TestConfigurationBean {

    public TestConfigurationBean(TestBean testBean) {
        this.testBean = testBean;
    }

    private TestBean testBean;

}

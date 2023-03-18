package com.example.factorybean.bean;


import org.springframework.stereotype.Component;

/**
 * 测试bean
 *
 * @author maonengneng
 * @date 2023/02/25
 */
@Component
public class TestBean {




    private String property1;

    private String property2;


    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
}

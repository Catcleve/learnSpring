package com.example.demo.bean;

import com.example.demo.Annotation.TestAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 测试bean
 *
 * @author maonengneng
 * @date 2023/02/25
 */
@TestAnno("testBean")
public class TestBean {

    @Autowired
    private TestAutoWirBean autoWirBean;

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
                "autoWirBean=" + autoWirBean +
                ", property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
}

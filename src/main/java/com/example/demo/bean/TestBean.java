package com.example.demo.bean;

import com.example.demo.Annotation.TestAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 测试bean
 *
 * @author maonengneng
 * @date 2023/02/25
 */
@TestAnno("testBean")
//@Component("321")
public class TestBean {


    @Resource(name = "123")
    private TestAutoWirBean autoWirBean;

    private String property1;

    private String property2;

    public TestAutoWirBean getAutoWirBean() {
        return autoWirBean;
    }

    public void setAutoWirBean(TestAutoWirBean autoWirBean) {
        this.autoWirBean = autoWirBean;
    }

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

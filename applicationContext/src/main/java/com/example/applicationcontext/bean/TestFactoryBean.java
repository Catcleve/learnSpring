package com.example.applicationcontext.bean;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试工厂bean
 *
 * @author maonengneng
 * @date 2023/03/14
 */
@Component
@ConfigurationProperties(prefix = "factory.bean")
@Setter
public class TestFactoryBean implements FactoryBean<TestBean> {


    private String propertyString;

    @Override
    public TestBean getObject() throws Exception {
        TestBean testBean = new TestBean();
        String[] split = propertyString.split(",");
        testBean.setProperty1(split[0]);
        testBean.setProperty2(split[1]);
        return testBean;
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }



}

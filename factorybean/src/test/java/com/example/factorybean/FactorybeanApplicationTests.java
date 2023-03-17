package com.example.factorybean;

import com.example.factorybean.bean.TestBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class FactorybeanApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 第一步解析名称
     * {@link AbstractBeanFactory#transformedBeanName}
     * getBean参数如果前面加上 "&"符号，则会返回bean对应的 factoryBean
     * @throws Exception 异常
     */
    @Test
    void getBeanTest() throws Exception {
        Object fac = applicationContext.getBean("fac");
        System.out.println("fac = " + fac);

        FactoryBean<?> bean = (FactoryBean<?>) applicationContext.getBean("&fac");
        TestBean object = (TestBean)bean.getObject();
        System.out.println(bean.getObjectType());
        System.out.println(fac == object);
        System.out.println(System.identityHashCode(fac));
    }

}

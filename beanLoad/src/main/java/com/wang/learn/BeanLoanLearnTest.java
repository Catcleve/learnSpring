package com.wang.learn;

import com.wang.learn.bean.TestBean;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * bean加载学习
 *
 * @author maonengneng
 * @date 2023/03/14
 */
public class BeanLoanLearnTest {


        @Test
        public void testAlias() {

            ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
            XmlBeanFactory factory = new XmlBeanFactory(resource);
            //第一次执行会完整的加载bean
            TestBean a = factory.getBean("a",TestBean.class);
            //第二次则会直接去缓存中获取bean
            TestBean a1 = factory.getBean("a",TestBean.class);
            System.out.println(a.getProperty1());
            System.out.println(a.getProperty2());

            //bean配置为string，获取的时候指定类型为integer，会通过getBean最后的转换方法来转换类型
            Integer str = factory.getBean("str", Integer.class);
            System.out.println("str = " + str);

        }

}

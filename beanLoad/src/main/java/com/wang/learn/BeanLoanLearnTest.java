package com.wang.learn;

import com.wang.learn.bean.TestBean;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * bean加载学习
 *
 * @author maonengneng
 * @date 2023/03/14
 */
public class BeanLoanLearnTest {


    /**
     * {@link AbstractBeanFactory#transformedBeanName}解析名称
     *
     * 学习了getBean的前几步 从缓存中加载，如何没有就存缓存的factoryBean中加载，然后执行 getObject方法来获取bean
     * 在返回对应的bean之前，会在finally中执行 BeanPostProcessor的postProcessAfterInitialization方法，也就是bean的后置处理器
     * 可以通过实现 BeanPostProcessor来执行自己业务逻辑
     * 这些全是从缓存中加载到bean的处理，如果缓存中加载不到，则执行从头加载的过程，见5.4学习
     */
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

package com.example.factorybean.InstantiationAwareBeanPostProcessorTest;

import com.example.factorybean.bean.TestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 *
 * 各种前置和后置处理器
 * 执行顺序为
 * 实例化前操作 可以替换bean为任意类型
 * 实例化后操作 只能修改属性
 * 初始化前操作 可以替换bean为任意类型
 * 初始化后操作 可以替换bean为任意类型
 * myaaa
 *
 * @author maonengneng
 * @date 2023/03/18
 */
@Component
public class Myaaa implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化前操作
     * 如果此方法不返回null，那么会结束整个bean的创建过程
     * 见{@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInstantiation}
     * 所以在此方法调用之后如果结果不为null，就会调用
     * {@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization}方法
     * 来执行{@link BeanPostProcessor#postProcessAfterInitialization}方法
     * 从而实现能够正确地执行后处理器，然后就会返回bean
     * @param beanClass bean类
     * @param beanName  bean名字
     * @return {@link Object}
     * @throws BeansException 豆子例外
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("testBean".equals(beanName)) {
            System.out.println("实例化前操作");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("testBean".equals(beanName)) {
            System.out.println("实例化后操作");
            return true;
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("testBean".equals(beanName)) {
            System.out.println("初始化前操作");
            System.out.println("原本bean的hash为："+System.identityHashCode(bean));
            TestBean testBean = new TestBean();
            testBean.setProperty2("123");
            return testBean;
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("testBean".equals(beanName)) {
            System.out.println(((TestBean) bean).getProperty2());
            System.out.println("初始化后操作时bean的hash为："+System.identityHashCode(bean));
            System.out.println("初始化后操作");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

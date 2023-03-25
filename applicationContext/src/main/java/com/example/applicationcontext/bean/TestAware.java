package com.example.applicationcontext.bean;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 关于{@link AbstractAutowireCapableBeanFactory#ignoreDependencyInterface(Class)}
 * https://www.jianshu.com/p/3c7e0608ff1f
 *
 * 关于aware，详见{@link org.springframework.beans.factory.Aware}
 *
 * @author maonengneng
 * @date 2023/03/25
 */
@Component
@Getter
public class TestAware implements
        EnvironmentAware, BeanFactoryAware, ApplicationContextAware, ResourceLoaderAware,
        BeanNameAware, BeanClassLoaderAware {

    private Environment environment;
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;
    private ResourceLoader resourceLoader;
    private ClassLoader classLoader;
    private String name;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
